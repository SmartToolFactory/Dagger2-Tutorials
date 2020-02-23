package com.example.tutorial4_2subcomponents.model

import android.widget.Toast
import com.example.tutorial4_2subcomponents.MainActivity

class ToastMaker(private val mainActivity: MainActivity) {

    fun showToast(message: String?) {
        Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show()
    }

}