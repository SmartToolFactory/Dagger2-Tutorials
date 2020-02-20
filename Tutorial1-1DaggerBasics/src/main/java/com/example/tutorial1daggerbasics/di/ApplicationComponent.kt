package com.example.tutorial1daggerbasics.di

import com.example.tutorial1daggerbasics.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Component creates graph to inject objects.
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

}