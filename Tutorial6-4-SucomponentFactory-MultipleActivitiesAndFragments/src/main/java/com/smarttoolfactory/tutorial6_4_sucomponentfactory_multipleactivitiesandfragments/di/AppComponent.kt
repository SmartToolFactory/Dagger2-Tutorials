package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// This is parent component
@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}