package dev.jorikfat.viewstateadapter.screens.fields

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.jorikfat.viewstateadapter.models.form.Form
import dev.jorikfat.viewstateadapter.stubForms

class FieldsViewModel(
    private val formTitle : String
) : ViewModel(){

    @Suppress("UNCHECKED_CAST")
    class Factory(private val formTitle :String) :ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            FieldsViewModel(formTitle) as T
    }

    val form :Form = stubForms.first { it.title == formTitle }
    val fieldsData = FieldsData(form.fields)

    init {

    }
}