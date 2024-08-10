package dev.jorikfat.viewstateadapter.models.field

data class Field(
    val title :String,
    val value :String,
    val editable :Boolean
) {
    companion object {
        val stub = arrayOf(
            Field("Первое поле", "Первое значение", false),
            Field("Второе поле", "Второе значение", false)
        )
    }
}