package dev.jorikfat.viewstateadapter

import android.app.Application
import dev.jorikfat.viewstateadapter.models.field.Field
import dev.jorikfat.viewstateadapter.models.form.Form

class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}

val stubFields = listOf(
    Field("Первое поле", "Первое значение", false),
    Field("Второе поле", "Второе значение", false)
)

val stubForm = Form("Заглушка", stubFields)

val stubForms = listOf(
    stubForm,
    Form("Вторая форма", listOf(
        Field("Первое поле", "Значение 1", false),
        Field("Второе поле", "Значение 2", false),
    ))
)

