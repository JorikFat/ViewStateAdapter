package dev.jorikfat.viewstateadapter

import dev.jorikfat.viewstateadapter.models.form.Form

sealed interface NavDestination {
    data object Back :NavDestination
    sealed class Next :NavDestination {
        data object Forms :Next()
        class Fields(val form : Form) :Next()
        class Overview(val form :Form) :Next()
    }
}