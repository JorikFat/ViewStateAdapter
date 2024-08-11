package dev.jorikfat.viewstateadapter.screens.fields.components.buttons

sealed interface ButtonsViewState {
    data object Fixed :ButtonsViewState
    data class Mutable(val saveEnable :Boolean) :ButtonsViewState
}