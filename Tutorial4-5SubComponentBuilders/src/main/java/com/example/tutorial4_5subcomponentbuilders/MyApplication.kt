package com.example.tutorial4_5subcomponentbuilders

import android.app.Application
import com.example.tutorial4_5subcomponentbuilders.di.ApplicationComponent
import com.example.tutorial4_5subcomponentbuilders.di.ApplicationModule
import com.example.tutorial4_5subcomponentbuilders.di.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(applicationContext))
                .build()
    }

}