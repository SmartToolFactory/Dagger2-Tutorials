package com.example.tutorial1daggerbasics

import android.app.Application
import com.example.tutorial1daggerbasics.di.ApplicationComponent
import com.example.tutorial1daggerbasics.di.ApplicationModule
import com.example.tutorial1daggerbasics.di.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        applicationComponent = createMyComponent()
    }

    private fun createMyComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule())
                .build()
    }

}