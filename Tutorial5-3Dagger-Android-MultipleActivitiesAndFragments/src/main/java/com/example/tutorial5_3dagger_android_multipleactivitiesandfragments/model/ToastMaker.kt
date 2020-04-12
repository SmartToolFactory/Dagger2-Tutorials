package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model

import android.content.Context
import android.widget.Toast

class ToastMaker(private val context: Context) {

    init {
        println("🎃 ToastMaker init context: $context")
    }

    fun showToast(message: String) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}