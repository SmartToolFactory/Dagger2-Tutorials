package com.example.tutorial4_2subcomponents.model

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Without @Singleton annotation constructor injection returns new instance
 */
// @Singleton
class MySharedPreferences @Inject constructor(private val mSharedPreferences: SharedPreferences) {

    fun putData(key: String?, data: Int) {
        mSharedPreferences.edit().putInt(key, data).apply()
    }

    fun getData(key: String?): Int {
        return mSharedPreferences.getInt(key, 0)
    }

    /*
        Here in this model class constructor injection is used as @Inject is added on the constructor.
        SharedPreferences object is passed from Module to constructor with provideSharedPreferences()
    */
    init {
        println("MySharedPreferences mSharedPreferences: $mSharedPreferences")
    }
}