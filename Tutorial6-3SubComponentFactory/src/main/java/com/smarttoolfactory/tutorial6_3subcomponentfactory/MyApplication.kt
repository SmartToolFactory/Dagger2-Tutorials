package com.smarttoolfactory.tutorial6_3subcomponentfactory

import android.app.Application
import com.smarttoolfactory.tutorial6_3subcomponentfactory.di.AppComponent
import com.smarttoolfactory.tutorial6_3subcomponentfactory.di.DaggerAppComponent


class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)

    }

}