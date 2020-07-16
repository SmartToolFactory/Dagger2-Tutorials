package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model

import android.app.Application
import android.widget.Toast

class ToastMaker(private val context: Application) {
    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}