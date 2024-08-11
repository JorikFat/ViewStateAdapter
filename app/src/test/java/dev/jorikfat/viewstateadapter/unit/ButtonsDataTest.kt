package dev.jorikfat.viewstateadapter.unit

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Assert.*
import dev.jorikfat.viewstateadapter.screens.fields.components.buttons.ButtonsData
import dev.jorikfat.viewstateadapter.screens.fields.components.buttons.ButtonsViewState
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


class ButtonsDataTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun initialState(){
        val next = ButtonsData(ButtonsViewState.Next)
        assertEquals("next state", ButtonsViewState.Next, next.value)
        val disableSave = ButtonsData(ButtonsViewState.SkipSave(false))
        assertEquals("disable save", ButtonsViewState.SkipSave(false), disableSave.value)
        val enableSave = ButtonsData(ButtonsViewState.SkipSave(true))
        assertEquals("enable save", ButtonsViewState.SkipSave(true), enableSave.value)
    }

    @Test
    fun listenCallbacks(){
        val data = ButtonsData(ButtonsViewState.SkipSave(false))
        val mockCallback = Mockito.mock(ButtonsData.Callbacks::class.java)
        data.callbacks = mockCallback
        data.save()
        Mockito.verify(mockCallback).save()
        data.skip()
        Mockito.verify(mockCallback).save()
    }

    @Test
    fun ignoreCallback(){
        val mockCallback = Mockito.mock(ButtonsData.Callbacks::class.java)
        val data = ButtonsData(ButtonsViewState.Next)
        data.save()
        Mockito.verify(mockCallback, Mockito.never()).save()
        data.skip()
        Mockito.verify(mockCallback, Mockito.never()).skip()
    }

    @Test
    fun ignoreSaveCallback(){
        val data = ButtonsData(ButtonsViewState.Next)
        val mockCallback = Mockito.mock(ButtonsData.Callbacks::class.java)
        data.callbacks = mockCallback
        data.save()
        Mockito.verify(mockCallback, Mockito.never()).save()
        data.skip()
        Mockito.verify(mockCallback).skip()
    }

    @Test
    fun updateState(){
        val mockObserver = Mockito.mock(Observer::class.java) as Observer<ButtonsViewState>
        val data = ButtonsData(ButtonsViewState.SkipSave(false))
        data.observeForever(mockObserver)
        Mockito.verify(mockObserver).onChanged(ButtonsViewState.SkipSave(false))
        data.show(true)
        Mockito.verify(mockObserver).onChanged(ButtonsViewState.SkipSave(true))
        data.show(false)
        Mockito.verify(mockObserver, Mockito.times(2)).onChanged(ButtonsViewState.SkipSave(false))
    }
}
