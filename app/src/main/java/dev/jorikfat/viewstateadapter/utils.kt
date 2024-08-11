package dev.jorikfat.viewstateadapter

import android.text.Editable
import android.text.TextWatcher

class SimpleWatcher(private val callback :(String)->Unit) :TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { /* ignore */ }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { /* ignore */ }

    override fun afterTextChanged(p0: Editable?) = callback.invoke(p0.toString())
}