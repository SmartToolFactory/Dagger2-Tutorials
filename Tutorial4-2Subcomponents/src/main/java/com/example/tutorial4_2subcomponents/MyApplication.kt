package com.example.tutorial4_2subcomponents

import android.app.Application
import android.content.SharedPreferences
import com.example.tutorial4_2subcomponents.di.ApplicationComponent
import com.example.tutorial4_2subcomponents.di.ApplicationModule
import com.example.tutorial4_2subcomponents.di.DaggerApplicationComponent
import com.example.tutorial4_2subcomponents.model.MySharedPreferences
import javax.inject.Inject

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    // Injected via Constructor injection, without @Singleton, it injects new instance after rotation
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences


    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(applicationContext))
                .build()

        // 🔥 To inject to this class we need to call inject method to create MyApplication_MemberInjector
        // 🔥🔥 Without this neither constructor nor module injection is possible
        applicationComponent.inject(this)

        println("🚙 MyApplication onCreate(): sharedPreferences: $sharedPreferences, mySharedPreferences: $mySharedPreferences")

    }

}