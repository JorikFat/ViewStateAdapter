package dev.jorikfat.viewstateadapter.screens.fields

import androidx.lifecycle.MutableLiveData
import dev.jorikfat.viewstateadapter.models.field.Field

class FieldsData(fields :List<Field>) :MutableLiveData<List<FieldViewState>>(
    fields.map { it.viewState }
){




}

private val Field.viewState get() = FieldViewState(title, value)
