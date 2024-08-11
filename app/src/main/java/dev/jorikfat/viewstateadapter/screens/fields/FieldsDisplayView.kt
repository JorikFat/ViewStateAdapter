package dev.jorikfat.viewstateadapter.screens.fields

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import dev.jorikfat.viewstateadapter.databinding.ItemFieldBinding

class FieldsDisplayView :LinearLayout {

    constructor(context :Context) :super(context)
    constructor(context :Context, attrs :AttributeSet) :super(context, attrs)
    constructor(context :Context, state :FieldViewState) :super(context) {
        setState(state)
    }

    private val binding :ItemFieldBinding = ItemFieldBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = VERTICAL
    }

    fun setState(state :FieldViewState){
        binding.title.text = state.title
        binding.value.text = state.value
    }
}