package com.smarttoolfactory.tutorial6_1componentfactory.di

import android.app.Application
import android.content.SharedPreferences
import com.smarttoolfactory.tutorial6_1componentfactory.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application,
                   @BindsInstance sharedPreferences: SharedPreferences): AppComponent
    }

}