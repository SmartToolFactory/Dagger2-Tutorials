package com.test.tutorial3_3qualifiers

import android.app.Application
import com.test.tutorial3_3qualifiers.di.DaggerUserComponent
import com.test.tutorial3_3qualifiers.di.UserComponent


class MyApplication : Application() {

    lateinit var userComponent: UserComponent
        private set

    override fun onCreate() {
        super.onCreate()
        userComponent = DaggerUserComponent.create()
    }

}