package dev.jorikfat.viewstateadapter.screens.fields.presentation

import androidx.lifecycle.MutableLiveData
import dev.jorikfat.viewstateadapter.models.field.Field

class FieldsData(
    fields: List<Field>,
    private val mapper :FieldsMapper = FieldsMapper()
) : MutableLiveData<List<FieldViewState>>(fields.map(mapper::toViewState)) {

    private val map :Map<FieldViewState, Field> = value!!.zip(fields).toMap()
    var callback :Callback? = null
    val updatedFields: List<Field> get() = value!!.map(mapper::toEntity)

    fun updateValue(field :FieldViewState.Edit, newValue :String){
        field.value = newValue
        callback?.updateValue(entity(field), newValue)
    }

    private fun entity(state: FieldViewState) = map[state]!!

    interface Callback {
        fun updateValue(field :Field, value :String)
    }
}
