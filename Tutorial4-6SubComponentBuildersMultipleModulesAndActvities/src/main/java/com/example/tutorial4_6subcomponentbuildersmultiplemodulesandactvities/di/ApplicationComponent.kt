package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// This is parent component
@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {

    /**
     * Calls SubComponent Builder in SecondActivity and MyFragment using ApplicationComponent
     */
    fun toastMakerBuilder(): ToastAndPreferencesSubComponent.Builder

    fun dummyDependencyBuilder(): DummyDependencyComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}