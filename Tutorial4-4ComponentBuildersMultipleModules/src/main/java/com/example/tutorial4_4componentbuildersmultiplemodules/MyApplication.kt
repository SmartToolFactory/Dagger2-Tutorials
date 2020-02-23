package com.example.tutorial4_4componentbuildersmultiplemodules

import android.app.Application
import com.example.tutorial4_4componentbuildersmultiplemodules.di.*

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    lateinit var appComponentWithBuilder: AppComponentWithBind
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .sensorControllerModule(SensorControllerModule())
                .toastMakerModule(ToastMakerModule())
                .build()
        appComponentWithBuilder = DaggerAppComponentWithBind
                .builder()
                .application(this)
                .build()
    }

}