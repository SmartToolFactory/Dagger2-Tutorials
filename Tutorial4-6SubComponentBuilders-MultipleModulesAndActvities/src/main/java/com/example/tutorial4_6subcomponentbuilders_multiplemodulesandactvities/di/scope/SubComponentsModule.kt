package com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.di.scope

import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.di.DummyDependencySubComponent
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.di.ToastAndPreferencesSubComponent
import dagger.Module

// The "subcomponents" attribute in the @Module annotation tells Dagger what
// Subcomponents are children of the Component this module is included in.
@Module(
        subcomponents = [
            ToastAndPreferencesSubComponent::class,
            DummyDependencySubComponent::class]
)
abstract class SubComponentsModule