package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments

import android.app.Application
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.AppComponent


class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)

    }

}