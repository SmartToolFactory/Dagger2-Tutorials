package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.scope.FragmentScope
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.settings.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SettingsActivityFragmentContributorModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSettingsFragment(): SettingsFragment

}