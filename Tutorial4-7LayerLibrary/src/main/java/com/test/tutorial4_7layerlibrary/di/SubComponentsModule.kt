package com.test.tutorial4_7layerlibrary.di

import dagger.Module

// The "subcomponents" attribute in the @Module annotation tells Dagger what
// Subcomponents are children of the Component this module is included in.
@Module(
        subcomponents = [
            LibraryActivitySubComponent::class]
)
abstract class SubComponentsModule