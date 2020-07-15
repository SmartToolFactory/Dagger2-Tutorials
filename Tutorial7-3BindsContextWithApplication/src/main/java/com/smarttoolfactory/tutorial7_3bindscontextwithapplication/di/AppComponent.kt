package com.smarttoolfactory.tutorial7_3bindscontextwithapplication.di

import android.app.Application
import com.smarttoolfactory.tutorial7_3bindscontextwithapplication.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}