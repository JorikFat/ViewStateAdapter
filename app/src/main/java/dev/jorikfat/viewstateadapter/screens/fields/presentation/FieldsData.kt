package dev.jorikfat.viewstateadapter.screens.fields.presentation

import androidx.lifecycle.MutableLiveData
import dev.jorikfat.viewstateadapter.models.field.Field

class FieldsData(fields: List<Field>) : MutableLiveData<List<FieldViewState>>(
    fields.map { it.viewState }
) {
    val fields: List<Field> get() = value!!.map { it.entity }
}

private val Field.viewState
    get() =
        if (editable) FieldViewState.Edit(title, value)
        else FieldViewState.Display(title, value)

private val FieldViewState.entity
    get() =
        when (this) {
            is FieldViewState.Display -> Field(title, value, false)
            is FieldViewState.Edit -> Field(title, value, true)
        }
