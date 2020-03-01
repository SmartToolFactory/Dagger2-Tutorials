package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module

import android.content.Context
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.scope.FragmentScope
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.model.DummyDependency
import dagger.Module
import dagger.Provides

@Module
class DashboardFragmentModule {

    @FragmentScope
    @Provides
    fun provideDummyDependency(context: Context): DummyDependency {
        return DummyDependency(context)
    }

}
