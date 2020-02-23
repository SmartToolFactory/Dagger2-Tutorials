package com.example.tutorial4_2subcomponents.di

import com.example.tutorial4_2subcomponents.MyApplication
import dagger.Component
import javax.inject.Singleton

// This is parent component
@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {

    // TODO Cannot be injected to Activity with Sub-Component
    // Not used in this example
    fun inject(myApplication: MyApplication)

    // factory method to instantiate the sub-component defined here (passing in the module instance)
    fun newActivitySubComponent(activityModule: ActivityModule): ActivitySubComponent
}