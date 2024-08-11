package dev.jorikfat.viewstateadapter.screens.overview

import android.os.Parcelable
import dev.jorikfat.viewstateadapter.models.form.Form
import kotlinx.parcelize.Parcelize

@Parcelize
data class FormParcelable(
    val title :String,
    val fields :List<FieldParcelable>
):Parcelable {
    constructor(form : Form) :this(form.title, form.fields.map(::FieldParcelable))
}