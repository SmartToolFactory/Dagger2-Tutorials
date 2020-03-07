package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main

import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.scope.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [FirstFragmentModule::class])
interface FirstFragmentSubComponent {

    fun inject(firstFragment: FirstFragment)

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): FirstFragmentSubComponent
    }

}