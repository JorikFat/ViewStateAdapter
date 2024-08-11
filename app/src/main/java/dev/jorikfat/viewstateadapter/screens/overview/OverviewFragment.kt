package dev.jorikfat.viewstateadapter.screens.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import dev.jorikfat.viewstateadapter.databinding.LayoutOverviewsBinding
import dev.jorikfat.viewstateadapter.models.form.Form
import dev.jorikfat.viewstateadapter.screens.BaseFragment

class OverviewFragment() : BaseFragment<LayoutOverviewsBinding>() {
    private val form : FormParcelable by lazy {
        requireArguments().getParcelable("form")!!
    }

    constructor(form :Form) :this(){
        arguments = bundleOf("form" to FormParcelable(form))
    }

    override val title: String get() = form.title

    override fun createLayout(layoutInflater: LayoutInflater): LayoutOverviewsBinding =
        LayoutOverviewsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout.list.adapter = OverviewAdapter(form.fields)
    }
}