package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.di

import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main.MyFragment
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main.MyFragmentSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MyFragmentSubComponent::class])
abstract class FragmentContributorModule {

    @Binds
    @IntoMap
    @ClassKey(MyFragment::class)
    abstract fun bindAndroidInjectorFactory(
            builder: MyFragmentSubComponent.Builder): AndroidInjector.Factory<*>

}