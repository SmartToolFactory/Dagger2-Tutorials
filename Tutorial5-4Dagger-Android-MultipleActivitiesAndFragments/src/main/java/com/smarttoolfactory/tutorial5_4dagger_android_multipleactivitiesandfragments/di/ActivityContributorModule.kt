package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.di

import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main.MainActivity
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main.MainActivitySubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivitySubComponent::class])
abstract class ActivityContributorModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindMainActivityFactory(builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<*>



}