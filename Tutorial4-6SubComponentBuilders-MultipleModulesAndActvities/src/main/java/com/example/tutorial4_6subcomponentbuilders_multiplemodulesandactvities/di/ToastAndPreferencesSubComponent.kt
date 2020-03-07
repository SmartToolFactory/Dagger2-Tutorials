package com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.di

import android.content.Context
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.FirstFragment
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.SecondActivity
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.di.scope.FragmentScope
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * This is a SubComponent with 2 modules [ToastMakerModule] and [MySharedPreferencesModule]
 * Used for injecting objects provided by these modules to activity[SecondActivity]
 * and fragment1([FirstFragment])
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
    fun inject(myFragment: FirstFragment)

    fun inject(secondActivity: SecondActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ToastAndPreferencesSubComponent
        @BindsInstance
        fun context(context: Context): Builder
    }
}