package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities

import android.app.Application
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.ApplicationComponent
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.DaggerApplicationComponent

class MyApplication : Application() {
   lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().application(this).build()
    }

}