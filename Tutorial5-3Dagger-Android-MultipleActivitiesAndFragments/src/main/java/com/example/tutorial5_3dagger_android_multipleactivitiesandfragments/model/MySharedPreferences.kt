package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model

import android.content.SharedPreferences

class MySharedPreferences(private val mSharedPreferences: SharedPreferences) {
    fun putData(key: String?, data: Int) {
        mSharedPreferences.edit().putInt(key, data).apply()
    }

    fun getData(key: String?): Int {
        return mSharedPreferences.getInt(key, 0)
    }

}