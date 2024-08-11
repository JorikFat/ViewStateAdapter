package dev.jorikfat.viewstateadapter.screens.forms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import dev.jorikfat.viewstateadapter.R
import dev.jorikfat.viewstateadapter.databinding.LayoutListBinding
import dev.jorikfat.viewstateadapter.screens.BaseFragment
import dev.jorikfat.viewstateadapter.screens.fields.FieldsFragment
import dev.jorikfat.viewstateadapter.stubForms

class FormsFragment : BaseFragment<LayoutListBinding>() {
    override fun createLayout(layoutInflater: LayoutInflater): LayoutListBinding =
        LayoutListBinding.inflate(layoutInflater)

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