package com.example.tutorial4_5subcomponentbuilders.di

import dagger.Component
import javax.inject.Singleton

// This is parent component
@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {

    // Calls SubComponent Builder from MainActivity using ApplicationComponent
    fun toastMakerBuilder(): ToastMakerSubComponent.Builder

}