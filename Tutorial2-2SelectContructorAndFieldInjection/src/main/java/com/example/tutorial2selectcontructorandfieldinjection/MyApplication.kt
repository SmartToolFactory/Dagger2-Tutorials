package com.example.tutorial2selectcontructorandfieldinjection

import android.app.Application
import com.example.tutorial2selectcontructorandfieldinjection.di.DaggerMyComponent
import com.example.tutorial2selectcontructorandfieldinjection.di.MyComponent
import com.example.tutorial2selectcontructorandfieldinjection.di.SharedPreferencesModule

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