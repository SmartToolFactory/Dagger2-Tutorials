package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main

import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.scope.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [SecondFragmentModule::class])
interface SecondFragmentSubComponent {

    fun inject(secondFragment: SecondFragment)

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): SecondFragmentSubComponent
    }

}