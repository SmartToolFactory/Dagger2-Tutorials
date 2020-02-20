package com.example.tutorial1basics3.di

import com.example.tutorial1basics3.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppContextModule::class])
interface AppContextComponent {

    fun inject(mainActivity: MainActivity)

}