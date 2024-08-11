package dev.jorikfat.viewstateadapter.screens.fields

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dev.jorikfat.viewstateadapter.R
import dev.jorikfat.viewstateadapter.databinding.LayoutFieldsBinding
import dev.jorikfat.viewstateadapter.models.form.Form
import dev.jorikfat.viewstateadapter.screens.BaseFragment
import dev.jorikfat.viewstateadapter.screens.overview.OverviewFragment

class FieldsFragment() : BaseFragment<LayoutFieldsBinding>() {
    private val title : String by lazy { requireArguments().getString("title")!! }
    private val viewModel :FieldsViewModel by lazy {
        ViewModelProvider(this, FieldsViewModel.Factory(title)).get()
    }
    private val viewAdapter :FieldsViewAdapter by lazy { FieldsViewAdapter(requireContext()) }

    constructor(form :Form) :this(){
        arguments = bundleOf("title" to form.title)
    }

    override fun createLayout(layoutInflater: LayoutInflater): LayoutFieldsBinding =
        LayoutFieldsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = title
        viewModel.fieldsData.observe(viewLifecycleOwner){
            it.map { viewAdapter.toView(it) }
                .forEach { layout.fields.addView(it) }
        }
        layout.save.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, OverviewFragment(viewModel.form))
                .addToBackStack(null)
                .commit()
        }
    }
}