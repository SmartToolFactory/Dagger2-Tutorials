package com.smarttoolfactory.tutorial6_3subcomponentfactory.di

import dagger.Module

// The "subcomponents" attribute in the @Module annotation tells Dagger what
// Subcomponents are children of the Component this module is included in.
@Module(
        subcomponents = [
            DummyDependencySubComponent::class,
            ToastAndPreferencesSubComponent::class
        ]
)
abstract class SubComponentsModule