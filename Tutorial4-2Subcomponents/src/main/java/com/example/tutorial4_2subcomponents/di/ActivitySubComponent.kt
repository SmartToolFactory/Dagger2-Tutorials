package com.example.tutorial4_2subcomponents.di

import com.example.tutorial4_2subcomponents.MainActivity
import dagger.Subcomponent

/**
 *
 * SubComponent generally used for injecting short lived objects to Activities,
 * Fragments or other Objects
 *
 * !!! Only 1 Component can be injected to an Activity, Fragment or Object
 */
@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivitySubComponent {

    fun inject(mainActivity: MainActivity)

}