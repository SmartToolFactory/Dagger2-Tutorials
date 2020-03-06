package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model

import android.content.SharedPreferences


class MySharedPreferences(private val sharedPreferences: SharedPreferences) {
    fun putData(key: String, data: Int) {
        sharedPreferences.edit().putInt(key, data).apply()
    }

    fun getData(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

}