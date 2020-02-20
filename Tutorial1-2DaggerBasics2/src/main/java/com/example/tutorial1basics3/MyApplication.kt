package com.example.tutorial1basics3

import android.app.Application
import com.example.tutorial1basics3.di.AppContextComponent
import com.example.tutorial1basics3.di.AppContextModule
import com.example.tutorial1basics3.di.DaggerAppContextComponent

class MyApplication : Application() {

    lateinit var appContextComponent: AppContextComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appContextComponent = DaggerAppContextComponent
                .builder()
                .appContextModule(AppContextModule(this))
                .build()
    }

}