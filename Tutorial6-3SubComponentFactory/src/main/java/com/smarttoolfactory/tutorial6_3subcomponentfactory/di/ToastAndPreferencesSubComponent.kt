package com.smarttoolfactory.tutorial6_3subcomponentfactory.di

import android.content.Context
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.scope.FragmentScope
import com.smarttoolfactory.tutorial6_3subcomponentfactory.MyFragment
import com.smarttoolfactory.tutorial6_3subcomponentfactory.SecondActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * This is a SubComponent with 2 modules [ToastMakerModule] and [MySharedPreferencesModule]
 * Used for injecting objects provided by these modules to activity[SecondActivity]
 * and fragment([MyFragment])
 *
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes
 *
 * !!! Only 1 Component can be injected to an Activity, Fragment or Object
 */
@FragmentScope
@Subcomponent(modules = [ToastMakerModule::class, MySharedPreferencesModule::class])
interface ToastAndPreferencesSubComponent {

    // !!! IMPORTANT: Only one Component can be injected to an Object
    fun inject(myFragment: MyFragment)

    fun inject(secondActivity: SecondActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ToastAndPreferencesSubComponent
    }
}