package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di

import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.scope.FragmentScope
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.main.MyFragment
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.main.MyFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentContributorModule {
    /**
     * FragmentContributorModule is used inside ActivityContributorModule
     * With @ContributesAndroidInjector(modules = MyFragmentModule.class)
     * defines which module will be used to inject objects to MyFragment
     *
     *
     * In this example [MainActivity] has [MyFragment] fragment1, and [MyFragment]
     * uses [MyFragmentModule] to inject objects
     *
     *
     *
     * Scope of @ContributesAndroidInjector methods and their modules should be same.
     * Otherwise app returns HAS CONFLICTING SCOPES error
     *
     */
    @FragmentScope
    @ContributesAndroidInjector(modules = [MyFragmentModule::class])
    abstract fun contributeMyFragment(): MyFragment
}