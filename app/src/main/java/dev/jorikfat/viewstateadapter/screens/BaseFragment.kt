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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = createLayout(inflater)
        return layout.root
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}