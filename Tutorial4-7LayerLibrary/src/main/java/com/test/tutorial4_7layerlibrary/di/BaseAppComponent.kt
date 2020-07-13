package com.test.tutorial4_7layerlibrary.di

import android.app.Application
import com.test.tutorial4_7layerlibrary.model.LibraryObject
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubComponentsModule::class, BaseAppModule::class])
interface BaseAppComponent {

    fun librarySubComponentBuilder(): LibraryActivitySubComponent.Builder

    /**
     * 🔥🔥🔥 This method is required to get this object from a class that uses this component
     * as dependency
     */
    fun getLibraryObject(): LibraryObject

//    fun getSensorController(): SensorController


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): BaseAppComponent
    }
}