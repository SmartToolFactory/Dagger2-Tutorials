package com.example.tutorial4_3componentbuilders

import android.app.Application
import com.example.tutorial4_3componentbuilders.di.*

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    lateinit var appComponentWithBindsInstance: AppComponentWithBindsInstance
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()

        appComponentWithBindsInstance = DaggerAppComponentWithBindsInstance
                .builder()
//                .application(this)
                .build()
    }

}