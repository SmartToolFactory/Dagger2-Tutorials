package com.test.tutorial4_7layerlibrary.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubComponentsModule::class, BaseAppModule::class])
interface BaseAppComponent {

    fun librarySubComponentBuilder(): LibraryActivitySubComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): BaseAppComponent
    }
}