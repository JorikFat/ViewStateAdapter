package dev.jorikfat.viewstateadapter.screens.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import dev.jorikfat.viewstateadapter.databinding.LayoutOverviewsBinding
import dev.jorikfat.viewstateadapter.models.form.Form
import dev.jorikfat.viewstateadapter.screens.BaseFragment
import dev.jorikfat.viewstateadapter.stubForms

class OverviewFragment() : BaseFragment<LayoutOverviewsBinding>() {
    private val form :Form by lazy {
        stubForms.first {
            it.title == requireArguments().getString("title")
        }
    }

    constructor(form :Form) :this(){
        arguments = bundleOf("title" to form.title)
    }

    override fun createLayout(layoutInflater: LayoutInflater): LayoutOverviewsBinding =
        LayoutOverviewsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = form.title
        layout.list.adapter = OverviewAdapter(form.fields)
    }
}