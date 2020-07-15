package com.test.tutorial4_7layerlibrary.di

import android.app.Application
import android.content.SharedPreferences
import com.test.tutorial4_7layerlibrary.model.LibraryObject
import com.test.tutorial4_7layerlibrary.model.ToastMaker
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SubComponentsModule::class, BaseAppModule::class])
interface BaseAppComponent {

    fun librarySubComponentBuilder(): LibraryActivitySubComponent.Builder


    /**
     * 🔥🔥🔥 This method is required to get this object from a class that uses this component
     * as dependent component
     */
    fun getSharedPreferences(): SharedPreferences

    /**
     * 🔥🔥🔥 This method is required to get this object from a class that uses this component
     * as dependent component
     */
    fun getToastMaker(): ToastMaker

    /**
     * 🔥🔥🔥 This method is required to get this object from a class that uses this component
     * as dependent component
     */
    fun getLibraryObject(): LibraryObject


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): BaseAppComponent
    }
}