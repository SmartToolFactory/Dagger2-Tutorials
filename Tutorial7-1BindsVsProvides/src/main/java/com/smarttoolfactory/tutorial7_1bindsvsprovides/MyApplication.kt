package com.smarttoolfactory.tutorial7_1bindsvsprovides

import android.app.Application
import com.smarttoolfactory.tutorial7_1bindsvsprovides.di.AppComponent
import com.smarttoolfactory.tutorial7_1bindsvsprovides.di.DaggerAppComponent

open class MyApplication : Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Application
        return DaggerAppComponent.factory().create(this)
    }
}