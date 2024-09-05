package com.nomaddeveloper.haleki.util

import android.app.Activity
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding

object ViewUtil {
    fun edgeToEdge(activity: Activity, contentView: View) {
        WindowCompat.setDecorFitsSystemWindows(activity.window, false)
        contentView.setOnApplyWindowInsetsListener { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun setContentView(activity: Activity, binding: ViewBinding) {
        activity.setContentView(binding.root)
    }
}