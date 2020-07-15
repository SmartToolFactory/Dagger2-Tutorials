package com.smarttoolfactory.tutorial6_1componentfactory

import android.app.Application
import android.preference.PreferenceManager
import com.smarttoolfactory.tutorial6_1componentfactory.di.AppComponent
import com.smarttoolfactory.tutorial6_1componentfactory.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
    private set

    override fun onCreate() {
        super.onCreate()

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        appComponent = DaggerAppComponent
                .factory()
                .create(this,sharedPreferences)
    }


}