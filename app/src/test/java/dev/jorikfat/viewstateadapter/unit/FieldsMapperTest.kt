package dev.jorikfat.viewstateadapter.unit

import dev.jorikfat.viewstateadapter.models.field.Field
import dev.jorikfat.viewstateadapter.screens.fields.presentation.FieldViewState
import dev.jorikfat.viewstateadapter.screens.fields.presentation.FieldsMapper
import org.junit.Test
import org.junit.Assert.*

class FieldsMapperTest {

    @Test
    fun editableToViewState(){
        val mapper = FieldsMapper()
        val field = Field("title", "value", true)
        val viewState :FieldViewState = mapper.toViewState(field)
        assertTrue(viewState is FieldViewState.Edit)
        viewState as FieldViewState.Edit
        assertEquals("equals title", field.title, viewState.title)
        assertEquals("equals value", field.value, viewState.value)
        val newValue = "newValue"
        viewState.value = newValue
        assertEquals("value updated", newValue, viewState.value)
    }

    @Test
    fun displayToViewState(){
        val mapper = FieldsMapper()
        val field = Field("title", "value", false)
        val viewState :FieldViewState = mapper.toViewState(field)
        assertTrue(viewState is FieldViewState.Display)
        viewState as FieldViewState.Display
        assertEquals("equals title", field.title, viewState.title)
        assertEquals("equals value", field.value, viewState.value)
    }

    @Test
    fun editableToEntity(){
        val mapper = FieldsMapper()
        val state = FieldViewState.Edit("title", "value")
        val field :Field = mapper.toEntity(state)
        assertEquals("equals title", state.title, field.title)
        assertEquals("equals value", state.value, field.value)
        assertTrue("editable", field.editable)
    }

    @Test
    fun displayedToEntity(){
        val mapper = FieldsMapper()
        val state = FieldViewState.Display("title", "value")
        val field :Field = mapper.toEntity(state)
        assertEquals("equals title", state.title, field.title)
        assertEquals("equals value", state.value, field.value)
        assertFalse("editable", field.editable)
    }
}