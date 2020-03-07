package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di

import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main.FirstFragmentSubComponent
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main.SecondFragmentSubComponent
import dagger.Module

@Module(
        subcomponents = [
            FirstFragmentSubComponent::class,
            SecondFragmentSubComponent::class
        ]
)
class FragmentSubComponentsModule