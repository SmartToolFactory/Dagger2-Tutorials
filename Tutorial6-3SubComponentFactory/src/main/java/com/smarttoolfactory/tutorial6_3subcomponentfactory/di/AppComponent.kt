package com.smarttoolfactory.tutorial6_3subcomponentfactory.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// This is parent component
@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    val dummyDependencyComponentFactory: DummyDependencySubComponent.Factory
    val toastAndSharedPreferencesFactory: ToastAndPreferencesSubComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}