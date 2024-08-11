package dev.jorikfat.viewstateadapter.screens.forms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dev.jorikfat.viewstateadapter.databinding.LayoutListBinding
import dev.jorikfat.viewstateadapter.dp
import dev.jorikfat.viewstateadapter.screens.BaseFragment
import dev.jorikfat.viewstateadapter.setSpace
import dev.jorikfat.viewstateadapter.stubForms

class FormsFragment : BaseFragment<LayoutListBinding>() {
    override fun createLayout(layoutInflater: LayoutInflater): LayoutListBinding =
        LayoutListBinding.inflate(layoutInflater)
    override val title: String = "Формы"
    private val viewModel :FormsViewModel by lazy {
        val proxy = requireActivity() as FormsViewModel.Host.Proxy
        val factory :FormsViewModel.Factory = FormsViewModel.Factory(proxy.formsHost)
        ViewModelProvider(this, factory).get()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout.list.setSpace(16.dp)
        layout.list.adapter = FormsAdapter(stubForms, viewModel::selectForm)
    }
}