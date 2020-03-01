package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.MainActivity
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.MainActivityModule
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentContributorModule::class])
    abstract fun contributeMainActivity(): MainActivity

}