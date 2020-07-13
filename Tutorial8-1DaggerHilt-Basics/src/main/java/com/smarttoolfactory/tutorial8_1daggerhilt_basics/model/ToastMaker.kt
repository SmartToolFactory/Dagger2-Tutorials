package com.smarttoolfactory.tutorial8_1daggerhilt_basics.model

import android.content.Context
import android.widget.Toast

class ToastMaker(private val context: Context) {

    fun showToast(message: String) {
        println("🔥 ToastMaker showToast() context: $context")
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}