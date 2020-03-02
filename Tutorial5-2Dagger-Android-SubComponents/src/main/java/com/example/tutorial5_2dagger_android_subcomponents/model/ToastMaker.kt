package com.example.tutorial5_2dagger_android_subcomponents.model

import android.content.Context
import android.widget.Toast

class ToastMaker(private val context: Context) {

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}