package dev.jorikfat.viewstateadapter.screens.forms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.jorikfat.viewstateadapter.R
import dev.jorikfat.viewstateadapter.databinding.LayoutListBinding
import dev.jorikfat.viewstateadapter.screens.fields.FieldsFragment
import dev.jorikfat.viewstateadapter.screens.overview.OverviewFragment
import dev.jorikfat.viewstateadapter.stubForms

class FormsFragment : Fragment() {
    private val layout by lazy { LayoutListBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = layout.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = "Формы"
        layout.list.adapter = FormsAdapter(stubForms){
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FieldsFragment(it))
                .addToBackStack(null)
                .commit()
        }
    }
}