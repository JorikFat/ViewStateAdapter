package dev.jorikfat.viewstateadapter.screens.fields.presentation

import androidx.lifecycle.MutableLiveData
import dev.jorikfat.viewstateadapter.models.field.Field

class FieldsData(fields: List<Field>) : MutableLiveData<List<FieldViewState>>(
    fields.map { it.viewState }
) {
    private val map :Map<FieldViewState, Field> = value!!.zip(fields).toMap()
    var callback :Callback? = null
    val updatedFields: List<Field> get() = value!!.map { it.entity }

    fun updateValue(field :FieldViewState.Edit, newValue :String){
        field.value = newValue
        callback?.updateValue(entity(field), newValue)
    }

    private fun entity(state: FieldViewState) = map[state]!!

    interface Callback {
        fun updateValue(field :Field, value :String)
    }
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
