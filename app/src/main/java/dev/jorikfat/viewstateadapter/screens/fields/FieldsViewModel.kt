package dev.jorikfat.viewstateadapter.screens.fields

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.jorikfat.viewstateadapter.models.form.Form
import dev.jorikfat.viewstateadapter.screens.fields.presentation.FieldsData
import dev.jorikfat.viewstateadapter.stubForms

class FieldsViewModel(
    private val host :Host,
    formTitle : String,

) : ViewModel(){

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val host :Host,
        private val formTitle :String
    ) :ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            FieldsViewModel(host, formTitle) as T
    }

    val form :Form = stubForms.first { it.title == formTitle }
    val fieldsData = FieldsData(form.fields)

    fun save() {
        host.complete(Form(form.title, fieldsData.fields))
    }

    interface Host {
        fun complete(form :Form)

        interface Proxy {
            val fieldsHost :Host
        }
    }
}