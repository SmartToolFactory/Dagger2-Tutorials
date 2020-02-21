package com.example.tutorial3scope2.model

import android.content.SharedPreferences
import com.example.tutorial3scope2.MainActivity
import com.example.tutorial3scope2.di.MyComponent
import javax.inject.Inject

/**
 * Scope of Injected class depends on the component of the class it's injeceted to
 * [MyComponent] is injected to [MainActivity]
 * scope pf this class only be same as MyComponent's scope or un-scoped.
 *
 *
 * Error when this class is scoped: MyComponent scoped with @Singleton may not reference bindings with different scopes
 *
 */

/*
    Here in this model class constructor injection is used as @Inject is added on the constructor.
    SharedPreferences object is passed from Module to constructor with provideSharedPreferences()
*/
class MySharedPreferences @Inject constructor(private val mSharedPreferences: SharedPreferences) {

    fun putData(key: String?, data: Int) {
        mSharedPreferences.edit().putInt(key, data).apply()
    }

    fun getData(key: String?): Int {
        return mSharedPreferences.getInt(key, 0)
    }

}