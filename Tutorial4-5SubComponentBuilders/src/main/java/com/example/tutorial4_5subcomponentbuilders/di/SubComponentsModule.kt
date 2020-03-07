package com.example.tutorial4_5subcomponentbuilders.di

import dagger.Module

// The "subcomponents" attribute in the @Module annotation tells Dagger what
// Subcomponents are children of the Component this module is included in.
@Module(
        subcomponents = [ToastMakerSubComponent::class]
)
abstract class SubComponentsModule