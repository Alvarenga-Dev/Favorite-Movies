package com.alvarengadev.favoritemovies.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

class GetDisplayUtils(private val context: Context) {

    private val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    private val display = windowManager.defaultDisplay
    private val metrics = DisplayMetrics()

    fun getMetrics() = display.getMetrics(metrics)

    fun getWidth(): Int = metrics.widthPixels

    fun getHeight(): Int = metrics.heightPixels
}