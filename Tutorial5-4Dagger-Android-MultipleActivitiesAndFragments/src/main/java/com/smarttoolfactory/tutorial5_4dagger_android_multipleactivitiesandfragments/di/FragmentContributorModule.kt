package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.di

import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main.FirstFragment
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main.FirstFragmentSubComponent
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main.SecondFragment
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main.SecondFragmentSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [
    FirstFragmentSubComponent::class,
    SecondFragmentSubComponent::class])
abstract class FragmentContributorModule {

    @Binds
    @IntoMap
    @ClassKey(FirstFragment::class)
    abstract fun bindFirstFragmentAndroidInjectorFactory(
            builder: FirstFragmentSubComponent.Builder): AndroidInjector.Factory<*>


    @Binds
    @IntoMap
    @ClassKey(SecondFragment::class)
    abstract fun bindSecondFragmentAndroidInjectorFactory(
            builder: SecondFragmentSubComponent.Builder): AndroidInjector.Factory<*>


}