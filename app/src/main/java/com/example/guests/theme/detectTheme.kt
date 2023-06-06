package com.example.guests.theme

import android.content.Context
import android.content.res.Configuration

class detectTheme(){
    fun isDarkThemeEnabled(context: Context): Boolean {
        val currentNightMode = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }
    }
