package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di

import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main.MainActivitySubComponent
import dagger.Module

// This module tells a Component which are its sub components
@Module(
        subcomponents = [
            MainActivitySubComponent::class
        ]
)
class ActivitySubComponentsModule