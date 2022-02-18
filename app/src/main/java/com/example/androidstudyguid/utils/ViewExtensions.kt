package com.example.androidstudyguid.utils

import android.view.View

fun View.visibleIf(condition: Boolean) {
    if (condition) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}
