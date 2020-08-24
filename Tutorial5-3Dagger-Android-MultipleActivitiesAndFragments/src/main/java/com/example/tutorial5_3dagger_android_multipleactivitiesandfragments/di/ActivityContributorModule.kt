package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di

import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.scope.ActivityScope
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.main.MainActivity
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.main.MainActivityModule
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.second.SecondActivity
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.second.SecondActivityModule
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.third.ThirdActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * [MainActivity] declares [MainActivityModule] to inject dependencies provided in [MainActivityModule]
 * To be able to inject dependencies to fragments inside [MainActivity] it defines [FragmentContributorModule]
 *
 *
 *
 * contributeMainActivity method with @ContributesAndroidInjector
 * annotation replaces MainActivityComponent of non dagger-android.
 *
 *
 * @ContributesAndroidInjector replaces MainActivitySubComponent
 * if the sub-component and it's builder has NO methods.
 *
 *
 *
 * Scope of contributor methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 */
@Module
abstract class ActivityContributorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentContributorModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SecondActivityModule::class])
    abstract fun contributeSecondActivity(): SecondActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeThirdActivity(): ThirdActivity
}