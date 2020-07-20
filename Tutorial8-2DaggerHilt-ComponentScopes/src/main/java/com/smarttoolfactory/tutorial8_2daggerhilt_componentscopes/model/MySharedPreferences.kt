package com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model

import android.content.SharedPreferences

class MySharedPreferences(private val mSharedPreferences: SharedPreferences) {
    fun putData(key: String?, data: Int) {
        mSharedPreferences.edit().putInt(key, data).apply()
    }

    fun getData(key: String?): Int {
        return mSharedPreferences.getInt(key, 0)
    }

}