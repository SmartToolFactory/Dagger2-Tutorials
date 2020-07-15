package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di

import android.app.Application
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.MainActivity
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