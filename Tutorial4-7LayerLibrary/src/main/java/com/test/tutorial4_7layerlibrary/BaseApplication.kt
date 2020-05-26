package com.test.tutorial4_7layerlibrary

import android.app.Application
import android.content.Context
import com.test.tutorial4_7layerlibrary.di.BaseAppComponent
import com.test.tutorial4_7layerlibrary.di.DaggerBaseAppComponent

abstract class BaseApplication : Application() {

    lateinit var baseAppComponent: BaseAppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        baseAppComponent = DaggerBaseAppComponent.builder().application(this).build()

    }


    companion object {
        @JvmStatic
        fun baseComponent(context: Context) =
                (context.applicationContext as BaseApplication).baseAppComponent
    }
}