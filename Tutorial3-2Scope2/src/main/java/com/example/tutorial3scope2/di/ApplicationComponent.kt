package com.example.tutorial3scope2.di

import com.example.tutorial3scope2.MainActivity
import dagger.Component

@Component(modules = [ApplicationModule::class])
@ApplicationScope
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}