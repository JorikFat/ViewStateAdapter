package dev.jorikfat.viewstateadapter.screens.fields.presentation

sealed class FieldViewState(val title :String) {
    class Display(title :String, val value :String) :FieldViewState(title)
    class Edit(title :String, var value :String) :FieldViewState(title)
}