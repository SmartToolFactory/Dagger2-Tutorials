package com.example.tutorial3scope2.di

import com.example.tutorial3scope2.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [SharedPreferencesModule::class])
@Singleton
interface MyComponent {
    fun inject(mainActivity: MainActivity?)
}