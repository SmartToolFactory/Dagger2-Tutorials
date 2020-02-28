package com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder

import android.app.Application
import android.preference.PreferenceManager
import com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.di.AppComponentWithBuilder
import com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.di.AppComponentWithFactory
import com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.di.DaggerAppComponentWithBuilder
import com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.di.DaggerAppComponentWithFactory


class MyApplication : Application() {

    lateinit var appComponentWithFactory: AppComponentWithFactory
        private set

    lateinit var appComponentWithBuilder: AppComponentWithBuilder
        private set

    override fun onCreate() {
        super.onCreate()

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)

        // AppComponent that uses Factory
        appComponentWithFactory = DaggerAppComponentWithFactory
                .factory()
                .create(this, sharedPreferences)

        // AppComponent that uses Builder
        appComponentWithBuilder = DaggerAppComponentWithBuilder
                .builder()
                .application(this)
                .sharedPreferences(sharedPreferences)
                .build()
    }


}