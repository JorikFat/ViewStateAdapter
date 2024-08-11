package dev.jorikfat.viewstateadapter.screens.fields.presentation

import dev.jorikfat.viewstateadapter.models.field.Field

class FieldsMapper {
    fun toViewState(field :Field) :FieldViewState =
        if (field.editable) FieldViewState.Edit(field.title, field.value)
        else FieldViewState.Display(field.title, field.value)

    fun toEntity(state :FieldViewState) :Field =
        when (state) {
            is FieldViewState.Display -> Field(state.title, state.value, false)
            is FieldViewState.Edit -> Field(state.title, state.value, true)
        }
}