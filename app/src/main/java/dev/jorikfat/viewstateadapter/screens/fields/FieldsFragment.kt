package dev.jorikfat.viewstateadapter.screens.fields

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dev.jorikfat.viewstateadapter.createRectangle
import dev.jorikfat.viewstateadapter.databinding.LayoutFieldsBinding
import dev.jorikfat.viewstateadapter.dp
import dev.jorikfat.viewstateadapter.models.form.Form
import dev.jorikfat.viewstateadapter.screens.BaseFragment
import dev.jorikfat.viewstateadapter.screens.fields.ui.FieldsViewAdapter

class FieldsFragment() : BaseFragment<LayoutFieldsBinding>() {
    private val viewModel :FieldsViewModel by lazy {
        val proxy = requireActivity() as FieldsViewModel.Host.Proxy
        val factory = FieldsViewModel.Factory(proxy.fieldsHost, title)
        ViewModelProvider(this, factory).get()
    }
    private val viewAdapter : FieldsViewAdapter by lazy { FieldsViewAdapter(requireContext()) }

    constructor(form :Form) :this(){
        arguments = bundleOf("title" to form.title)
    }

    override val title: String get() = requireArguments().getString("title")!!

    override fun createLayout(layoutInflater: LayoutInflater): LayoutFieldsBinding =
        LayoutFieldsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout.fields.dividerDrawable = createRectangle(0, 16.dp)
        viewModel.fieldsData.observe(viewLifecycleOwner){
            it.map(viewAdapter::toView)
                .forEach(layout.fields::addView)
        }
        layout.save.setOnClickListener { viewModel.save() }
        layout.skip.setOnClickListener { viewModel.skip() }
    }
}