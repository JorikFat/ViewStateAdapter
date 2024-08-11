package dev.jorikfat.viewstateadapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jorikfat.viewstateadapter.models.form.Form
import dev.jorikfat.viewstateadapter.screens.fields.FieldsViewModel
import dev.jorikfat.viewstateadapter.screens.forms.FormsViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel :ViewModel() {

    private val router = MutableSharedFlow<NavDestination>(extraBufferCapacity = 1)
    val navigator = router.asSharedFlow()

    init {
        viewModelScope.launch {
            router.emit(NavDestination.Next.Forms)
        }
    }

    val formsContainer = object :FormsViewModel.Host {
        override fun navForm(form: Form) {
            router.tryEmit(NavDestination.Next.Fields(form))
        }
    }
    val fieldsContainer = object :FieldsViewModel.Host {
        override fun complete(form: Form) {
            router.tryEmit(NavDestination.Next.Overview(form))
        }
    }
}