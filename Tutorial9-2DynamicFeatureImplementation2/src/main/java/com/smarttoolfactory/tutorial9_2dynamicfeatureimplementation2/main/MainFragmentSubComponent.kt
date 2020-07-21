package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.main

import android.app.Activity
import com.smarttoolfactory.tutorial9_2core.di.scope.FragmentScope
import dagger.BindsInstance
import dagger.Subcomponent


@FragmentScope
@Subcomponent(modules = [MainFragmentModule::class])
interface MainFragmentSubComponent {

    fun inject(mainFragment: MainFragment)

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: Activity): MainFragmentSubComponent
    }


}