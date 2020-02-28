package com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.di

import android.app.Application
import android.content.SharedPreferences
import com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponentWithFactory {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application,
                   @BindsInstance sharedPreferences: SharedPreferences): AppComponentWithFactory
    }

}