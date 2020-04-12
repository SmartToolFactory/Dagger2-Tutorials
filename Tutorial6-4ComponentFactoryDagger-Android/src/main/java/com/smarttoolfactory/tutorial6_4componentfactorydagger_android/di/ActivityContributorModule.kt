package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.module.MainActivityModule
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.scope.ActivityScope
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.main.MainActivity
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.settings.SettingsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainActivityFragmentContributorModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SettingsActivityFragmentContributorModule::class])
    abstract fun contributeSettingsActivity(): SettingsActivity

}