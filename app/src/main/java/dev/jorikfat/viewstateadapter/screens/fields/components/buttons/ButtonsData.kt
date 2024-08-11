package dev.jorikfat.viewstateadapter.screens.fields.components.buttons

import androidx.lifecycle.MutableLiveData

class ButtonsData(initial :ButtonsViewState) :MutableLiveData<ButtonsViewState>(initial) {
    var callbacks :Callbacks? = null

    fun show(saveEnable :Boolean) =
        postValue(ButtonsViewState.SkipSave(saveEnable))

    fun skip() = callbacks?.skip()

    fun save() {
        if(value!! == ButtonsViewState.Next) return
        callbacks?.save()
    }

    interface Callbacks {
        fun skip()
        fun save()
    }
}