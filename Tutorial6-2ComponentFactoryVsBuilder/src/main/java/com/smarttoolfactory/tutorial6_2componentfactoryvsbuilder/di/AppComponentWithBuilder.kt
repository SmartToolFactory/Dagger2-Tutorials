package com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.di

import android.app.Application
import android.content.SharedPreferences
import com.smarttoolfactory.tutorial6_2componentfactoryvsbuilder.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponentWithBuilder {

    fun inject(mainActivity: MainActivity)


    @Component.Builder
    interface Builder {

        fun build(): AppComponentWithBuilder

        // @BindsInstance replaces Builder appModule(AppModule appModule)
        // And removes Constructor with Application AppModule(Application)
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun sharedPreferences(sharedPreferences: SharedPreferences): Builder

    }

}