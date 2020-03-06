package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main

import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.scope.ActivityScope
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.di.FragmentContributorModule
import dagger.Subcomponent
import dagger.android.AndroidInjector


@ActivityScope
@Subcomponent(modules = [MainActivityModule::class, FragmentContributorModule::class])
interface MainActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}