package dev.jorikfat.viewstateadapter.screens.fields

import android.content.Context
import android.view.View

class FieldsViewAdapter(private val context : Context) {
    fun toView(field : FieldViewState) : View = FieldsDisplayView(context, field)
}