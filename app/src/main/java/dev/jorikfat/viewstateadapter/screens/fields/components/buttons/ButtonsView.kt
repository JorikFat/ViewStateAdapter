package dev.jorikfat.viewstateadapter.screens.fields.components.buttons

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.LifecycleOwner
import dev.jorikfat.viewstateadapter.databinding.ViewButtonsBinding

class ButtonsView :LinearLayout {

    constructor(context :Context) :super(context)
    constructor(context :Context, attrs :AttributeSet) :super(context, attrs)

    private val binding : ViewButtonsBinding = ViewButtonsBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = HORIZONTAL
    }

    fun attach(owner :LifecycleOwner, data :ButtonsData){
        binding.skip.setOnClickListener { data.skip() }
        if(data.value!! is ButtonsViewState.Mutable){
            binding.save.setOnClickListener { data.save() }
        }
        data.observe(owner){ state ->
            when(state){
                ButtonsViewState.Fixed -> {
                    binding.skip.text = "Далее"
                    binding.save.visibility = GONE
                }
                is ButtonsViewState.Mutable -> binding.save.isEnabled = state.saveEnable
            }
        }
    }
}