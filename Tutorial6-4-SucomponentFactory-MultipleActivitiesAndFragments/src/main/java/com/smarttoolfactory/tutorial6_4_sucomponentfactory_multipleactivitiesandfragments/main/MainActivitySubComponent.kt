package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main

import android.content.Context
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.FragmentSubComponentsModule
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.scope.ActivityScope
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * [FragmentSubComponentsModule] creates sub-component and
 * makes objects injected from that module be specific to fragments, and re-created
 * whenever fragments are created.
 */
@ActivityScope
@Subcomponent(modules = [
    MainActivityModule::class,
    FragmentSubComponentsModule::class])
interface MainActivitySubComponent {

    fun firstFragmentFactory(): FirstFragmentSubComponent.Factory
    fun secondFragmentFactory(): SecondFragmentSubComponent.Factory

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivitySubComponent
    }

    fun inject(mainActivity: MainActivity)

}