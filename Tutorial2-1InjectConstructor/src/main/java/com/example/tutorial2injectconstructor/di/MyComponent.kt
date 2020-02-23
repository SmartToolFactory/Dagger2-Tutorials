package com.example.tutorial2injectconstructor.di

import com.example.tutorial2injectconstructor.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [SharedPreferencesModule::class])
@Singleton
interface MyComponent {
    fun inject(mainActivity: MainActivity)
}