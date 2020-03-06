package com.example.tutorial5_2dagger_android_subcomponents3.di

import com.example.tutorial5_2dagger_android_subcomponents3.MainActivity
import com.example.tutorial5_2dagger_android_subcomponents3.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This Module actually contains SubComponents for Activities.
 * contributeMainActivity with  @ContributesAndroidInjector
 * replaces MainActivitySubComponent if the sub-component and it's
 * builder has NO methods.
 *
 *
 *
 * Scope of @ContributesAndroidInjector methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 */
@Module
abstract class ActivityContributorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SecondActivityModule::class])
    abstract fun contributeSecondActivity(): SecondActivity
}