package com.example.tutorial2injectconstructor.model

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/*
 * Without @Singleton annotation constructor injection does not inject a singleton object.
 * New instance of this object with @Inject constructor is created after each device rotation
 */
@Singleton
class MySharedPreferences @Inject constructor(mSharedPreferences: SharedPreferences) {

    private val mSharedPreferences: SharedPreferences

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
        println("MySharedPreferences Constructor with: $mSharedPreferences")
        this.mSharedPreferences = mSharedPreferences
    }
}