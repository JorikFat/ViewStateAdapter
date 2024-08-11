package dev.jorikfat.viewstateadapter.screens.fields.components.buttons

sealed interface ButtonsViewState {
    data object Next :ButtonsViewState
    data class SkipSave(val saveEnable :Boolean) :ButtonsViewState
}