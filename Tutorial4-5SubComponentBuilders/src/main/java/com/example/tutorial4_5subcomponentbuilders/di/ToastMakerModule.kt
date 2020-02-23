package com.example.tutorial4_5subcomponentbuilders.di

import android.content.Context
import com.example.tutorial4_5subcomponentbuilders.model.ToastMaker
import dagger.Module
import dagger.Provides

// This is SubComponent Module
/**
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes
 */
@Module
class ToastMakerModule {

    @ActivityScope
    @Provides
    fun provideToastMaker(context: Context): ToastMaker {
        println("ToastMakerModule context: $context")
        return ToastMaker(context)
    }

}