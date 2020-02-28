package com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.model

import android.content.SharedPreferences
import javax.inject.Inject

/*
   Here in this model class constructor injection is used as @Inject is added on the constructor.
   SharedPreferences object is passed from Module to constructor with provideSharedPreferences()
   */
class MySharedPreferences @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun putData(key: String, data: Int) {
        sharedPreferences.edit().putInt(key, data).apply()
    }

    fun getData(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

}