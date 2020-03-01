package com.example.tutorial2selectcontructorandfieldinjection.di

import com.example.tutorial2selectcontructorandfieldinjection.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [SharedPreferencesModule::class])
@Singleton
interface MyComponent {
    fun inject(mainActivity: MainActivity)
}