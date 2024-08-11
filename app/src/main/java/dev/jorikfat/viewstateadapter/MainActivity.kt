package dev.jorikfat.viewstateadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dev.jorikfat.viewstateadapter.screens.fields.FieldsFragment
import dev.jorikfat.viewstateadapter.screens.fields.FieldsViewModel
import dev.jorikfat.viewstateadapter.screens.forms.FormsFragment
import dev.jorikfat.viewstateadapter.screens.forms.FormsViewModel
import dev.jorikfat.viewstateadapter.screens.overview.OverviewFragment
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),
    FormsViewModel.Host.Proxy,
    FieldsViewModel.Host.Proxy
{
    private val viewModel :MainViewModel by lazy {
        ViewModelProvider(this).get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.navigator.collect(::navigate)
            }
        }
    }

    private fun navigate(destination :NavDestination) {
        val manager = supportFragmentManager
        if(destination == NavDestination.Back) {
            manager.popBackStack()
            return
        }
        val nextDestination = destination as NavDestination.Next
        val fragment = manager.findFragmentByTag(destination::class.java.simpleName)
            ?: fragmentFromScreen(nextDestination)
        manager.beginTransaction()
            .apply {
                if(manager.fragments.isEmpty()){
                    add(R.id.container, fragment, nextDestination::class.java.simpleName)
                } else {
                    replace(R.id.container, fragment, nextDestination::class.java.simpleName)
                    addToBackStack(null)
                }
            }
            .commit()
    }

    override val formsHost: FormsViewModel.Host
        get() = viewModel.formsContainer

    override val fieldsHost: FieldsViewModel.Host
        get() = viewModel.fieldsContainer

    private fun fragmentFromScreen(screen :NavDestination.Next) :Fragment =
        when(screen){
            NavDestination.Next.Forms -> FormsFragment()
            is NavDestination.Next.Fields -> FieldsFragment(screen.form)
            is NavDestination.Next.Overview -> OverviewFragment(screen.form)
        }
}