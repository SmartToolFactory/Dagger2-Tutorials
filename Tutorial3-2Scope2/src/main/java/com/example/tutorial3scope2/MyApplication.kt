package com.example.tutorial3scope2

import android.app.Application
import com.example.tutorial3scope2.di.ApplicationComponent
import com.example.tutorial3scope2.di.ApplicationModule
import com.example.tutorial3scope2.di.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(applicationContext))
                .build()
    }

}