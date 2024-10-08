package dev.jorikfat.viewstateadapter.screens.fields.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import dev.jorikfat.viewstateadapter.SimpleWatcher
import dev.jorikfat.viewstateadapter.databinding.ViewFieldEditBinding
import dev.jorikfat.viewstateadapter.screens.fields.presentation.FieldViewState

class FieldEditView :LinearLayout {

    constructor(context :Context) :super(context)
    constructor(context :Context, attrs : AttributeSet) :super(context, attrs)
    constructor(
        context :Context,
        state : FieldViewState.Edit,
        watcher :(FieldViewState.Edit, String)->Unit
    ) :super(context) {
        setState(state, watcher)
    }

    private val binding : ViewFieldEditBinding = ViewFieldEditBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = VERTICAL
    }

    fun setState(
        state :FieldViewState.Edit,
        watcher :(FieldViewState.Edit, String)->Unit
    ){
        binding.title.text = state.title
        binding.value.setText(state.value)
        binding.value.addTextChangedListener(SimpleWatcher { watcher.invoke(state, it) })
    }
}