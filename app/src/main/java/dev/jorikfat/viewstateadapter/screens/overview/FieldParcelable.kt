package dev.jorikfat.viewstateadapter.screens.overview

import android.os.Parcelable
import dev.jorikfat.viewstateadapter.models.field.Field
import kotlinx.parcelize.Parcelize

@Parcelize
data class FieldParcelable(
    val title :String,
    val value :String
) :Parcelable {
    constructor(field : Field) :this(field.title, field.value)
}