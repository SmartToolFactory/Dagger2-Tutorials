package com.smarttoolfactory.tutorial7_1bindsvsprovides.di

import android.app.Application
import com.smarttoolfactory.tutorial7_1bindsvsprovides.MainActivity
import com.smarttoolfactory.tutorial7_1bindsvsprovides.di.binds.ModuleWithBinds
import com.smarttoolfactory.tutorial7_1bindsvsprovides.di.provides.ModuleWithProvides
import dagger.BindsInstance
import dagger.Component

@Component(
        modules = [
            ModuleWithBinds::class,
            ModuleWithProvides::class
        ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): AppComponent

    }
}