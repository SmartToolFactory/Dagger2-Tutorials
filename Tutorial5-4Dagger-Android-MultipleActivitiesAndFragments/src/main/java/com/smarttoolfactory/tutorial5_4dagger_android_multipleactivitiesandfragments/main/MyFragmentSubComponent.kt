package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main

import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.scope.FragmentScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(modules = [MyFragmentModule::class])
interface MyFragmentSubComponent : AndroidInjector<MyFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MyFragment>()

}