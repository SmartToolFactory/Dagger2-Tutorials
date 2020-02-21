package com.example.tutorial3scope1

import android.app.Application
import com.example.tutorial3scope1.di.DaggerUserComponent
import com.example.tutorial3scope1.di.UserComponent

class MyApplication : Application() {

    lateinit var userComponent: UserComponent
        private set

    override fun onCreate() {
        super.onCreate()
        userComponent = DaggerUserComponent.create()
    }

}