package com.example.tutorial2injectconstructor

import android.app.Application
import com.example.tutorial2injectconstructor.di.DaggerMyComponent
import com.example.tutorial2injectconstructor.di.MyComponent
import com.example.tutorial2injectconstructor.di.SharedPreferencesModule

class MyApplication : Application() {

    lateinit var myComponent: MyComponent
        private set

    override fun onCreate() {
        super.onCreate()

        myComponent = DaggerMyComponent.builder()
                .sharedPreferencesModule(SharedPreferencesModule(applicationContext))
                .build()
    }

}