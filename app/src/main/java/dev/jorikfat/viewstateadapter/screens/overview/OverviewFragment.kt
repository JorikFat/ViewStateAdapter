package dev.jorikfat.viewstateadapter.screens.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.jorikfat.viewstateadapter.Field
import dev.jorikfat.viewstateadapter.databinding.LayoutOverviewsBinding

class OverviewFragment : Fragment() {
    private val layout by lazy { LayoutOverviewsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = layout.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout.list.adapter = OverviewAdapter(Field.stub.toList())
    }
}