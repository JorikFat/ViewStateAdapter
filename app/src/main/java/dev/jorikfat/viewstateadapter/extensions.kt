package dev.jorikfat.viewstateadapter

import android.content.res.Resources.getSystem
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setSpace(height: Int) {
    val divider = DividerItemDecoration(context, VERTICAL)
    divider.setDrawable(createRectangle(0, height))
    addItemDecoration(divider)
}

fun createRectangle(width: Int = 0, height: Int = 0, color: Int = Color.TRANSPARENT): Drawable =
    GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        setColor(color)
        setSize(width, height)
    }

val Int.dp: Int get() = (this * getSystem().displayMetrics.density).toInt()