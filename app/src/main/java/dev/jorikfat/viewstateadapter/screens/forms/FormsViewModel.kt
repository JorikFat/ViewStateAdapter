package dev.jorikfat.viewstateadapter.screens.forms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.jorikfat.viewstateadapter.models.form.Form

class FormsViewModel(
    private val host : Host
) :ViewModel() {

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val host :Host
    ) :ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            FormsViewModel(host) as T
    }

    fun selectForm(form : Form) =
        host.navForm(form)

    interface Host {
        fun navForm(form : Form)

        interface Proxy {
            val formsHost :Host
        }
    }
}