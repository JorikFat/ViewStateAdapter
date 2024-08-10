package dev.jorikfat.viewstateadapter.models.form

import dev.jorikfat.viewstateadapter.models.field.Field

data class Form(
    val title :String,
    val fields :List<Field>
)