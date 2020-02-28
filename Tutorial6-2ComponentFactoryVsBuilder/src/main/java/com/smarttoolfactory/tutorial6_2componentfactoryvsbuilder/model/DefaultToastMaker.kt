package com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.model

import android.app.Application
import android.widget.Toast

class DefaultToastMaker(private val application: Application) {

    fun showToast(message: String) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT).show()
    }
}