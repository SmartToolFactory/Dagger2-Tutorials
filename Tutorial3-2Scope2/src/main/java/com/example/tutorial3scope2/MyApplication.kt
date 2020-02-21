package com.example.tutorial3scope2

import android.app.Application
import com.example.tutorial3scope2.di.DaggerMyComponent
import com.example.tutorial3scope2.di.MyComponent
import com.example.tutorial3scope2.di.SharedPreferencesModule

class MyApplication : Application() {

    lateinit var myComponent: MyComponent
        private set

    override fun onCreate() {
        super.onCreate()
        myComponent = DaggerMyComponent.builder()
                .sharedPreferencesModule(SharedPreferencesModule(applicationContext))
                .build()
    }

}