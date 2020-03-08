package com.smarttoolfactory.tutorial7_2bindsvsprovides2.di

import android.content.Context
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.MainActivity
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.di.logger.LoggerModule
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.di.toaster.ToasterModule
import dagger.BindsInstance
import dagger.Component

@Component(
        modules = [
            LoggerModule::class,
            ToasterModule::class
        ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): AppComponent

    }
}