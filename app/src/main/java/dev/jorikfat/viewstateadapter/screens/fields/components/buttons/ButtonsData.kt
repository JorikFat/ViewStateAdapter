package dev.jorikfat.viewstateadapter.screens.fields.components.buttons

import androidx.lifecycle.MutableLiveData

class ButtonsData(initial :ButtonsViewState) :MutableLiveData<ButtonsViewState>(initial) {
    var callbacks :Callbacks? = null

    fun show(saveEnable :Boolean) =
        postValue(ButtonsViewState.Mutable(saveEnable))

    fun skip() = callbacks?.skip()

    fun save() = callbacks?.save()

    interface Callbacks {
        fun skip()
        fun save()
    }
}