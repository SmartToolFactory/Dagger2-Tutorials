package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model

import android.content.Context
import android.widget.Toast

class ToastMaker(private val context: Context) {
    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}