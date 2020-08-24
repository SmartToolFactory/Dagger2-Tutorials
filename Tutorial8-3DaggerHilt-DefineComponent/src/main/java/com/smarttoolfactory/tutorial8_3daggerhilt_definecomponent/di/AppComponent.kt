package com.smarttoolfactory.tutorial8_3daggerhilt_definecomponent.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ApplicationComponent

// Make AppComponent subcomponent of ApplicationComponent

@DefineComponent(parent = ApplicationComponent::class)
interface AppComponent {

    @DefineComponent.Builder
    interface Builder {
        fun application(@BindsInstance application: Application): Builder
        fun build(): AppComponent
    }

}