package com.smarttoolfactory.tutorial6_3subcomponentfactory.di

import android.content.Context
import com.smarttoolfactory.tutorial6_3subcomponentfactory.ActivityScopedFragment
import com.smarttoolfactory.tutorial6_3subcomponentfactory.MainActivity
import com.smarttoolfactory.tutorial6_3subcomponentfactory.di.scope.ActivityScope
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un- scoped but cannot have with different scopes
 */
@ActivityScope
@Subcomponent(modules = [DummyDependencyModule::class])
interface DummyDependencySubComponent {

    fun inject(activityScopedFragment: ActivityScopedFragment)

    fun inject(mainActivity: MainActivity)
    // 🔥 !!! IMPORTANT: Only one Component can be injected to an Object
// Second Activity  uses ToastAndPreferencesSubComponent already, results error
/*
     inject(SecondActivity secondActivity)
*/
// 🔥 !!! IMPORTANT2: Component's and Injected objects' scopes can not be different
// SensorController is also injected to MainActivity via Constructor Injection,
// thus both should have the same scope which is @ActivityScope
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DummyDependencySubComponent
    }
}