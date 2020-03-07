package com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.di

import android.app.Application
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.di.scope.SubComponentsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// This is parent component
@Component(modules = [ApplicationModule::class, SubComponentsModule::class])
@Singleton
interface ApplicationComponent {

    /**
     * Calls SubComponent Builder in SecondActivity and MyFragment using ApplicationComponent
     */
    fun toastMakerBuilder(): ToastAndPreferencesSubComponent.Builder

    fun dummyDependencyBuilder(): DummyDependencySubComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}