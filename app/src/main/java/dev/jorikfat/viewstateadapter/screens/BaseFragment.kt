package dev.jorikfat.viewstateadapter.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B :ViewBinding> :Fragment() {
    private var binding :B? = null
    protected val layout :B get() = binding!!
    abstract fun createLayout(layoutInflater: LayoutInflater) :B

    abstract val title :String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = createLayout(inflater)
        requireActivity().title = title
        return layout.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}