package com.smarttoolfactory.tutorial6_3subcomponentfactory.di

import android.content.Context
import com.example.tutorial4_6subcomponentbuilders_multiplemodulesandactvities.di.scope.FragmentScope
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.ToastMaker
import dagger.Module
import dagger.Provides

/**
 * This is SubComponent Module of [ToastAndPreferencesSubComponent] in this example
 * A module can be used in multiple components
 *
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un- scoped but cannot have with different scopes
 */
@Module
class ToastMakerModule {
    @FragmentScope
    @Provides
    fun provideToastMaker(context: Context): ToastMaker {
        return ToastMaker(context)
    }
}