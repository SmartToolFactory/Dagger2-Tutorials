package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model

import android.content.SharedPreferences

/*
   Here in this model class constructor injection is used as @Inject is added on the constructor.
   SharedPreferences object is passed from Module to constructor with provideSharedPreferences()
   */
class MySharedPreferences(private val sharedPreferences: SharedPreferences) {
    fun putData(key: String, data: Int) {
        sharedPreferences.edit().putInt(key, data).apply()
    }

    fun getData(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

}