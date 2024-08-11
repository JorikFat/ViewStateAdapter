package dev.jorikfat.viewstateadapter.screens.fields.ui

import android.content.Context
import android.view.View
import dev.jorikfat.viewstateadapter.screens.fields.presentation.FieldViewState

class FieldsViewAdapter(
    private val context :Context,
    private val watcher :(FieldViewState.Edit, String)->Unit
) {
    fun toView(field : FieldViewState) : View =
        when(field) {
            is FieldViewState.Display -> FieldDisplayView(context, field)
            is FieldViewState.Edit -> FieldEditView(context, field, watcher)
        }
}