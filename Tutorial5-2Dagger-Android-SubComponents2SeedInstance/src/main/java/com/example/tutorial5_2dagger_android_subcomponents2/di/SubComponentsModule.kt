package com.example.tutorial5_2dagger_android_subcomponents2.di

import dagger.Module

// The "subcomponents" attribute in the @Module annotation tells Dagger what
// Subcomponents are children of the Component this module is included in.
@Module(
        subcomponents = [
            ToastMakerSubComponent::class,
            LiveObjectSubComponent::class]
)
abstract class SubComponentsModule