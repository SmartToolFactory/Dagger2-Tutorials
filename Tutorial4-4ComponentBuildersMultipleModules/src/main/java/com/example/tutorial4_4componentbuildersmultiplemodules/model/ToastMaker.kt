package com.example.tutorial4_4componentbuildersmultiplemodules.model

import android.app.Application
import android.widget.Toast

class ToastMaker(private val application: Application) {

    fun showToast(message: String) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT).show()
    }

}