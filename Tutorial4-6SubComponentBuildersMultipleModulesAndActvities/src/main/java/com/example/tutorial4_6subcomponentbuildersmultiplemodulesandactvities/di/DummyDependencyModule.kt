package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di

import android.content.Context
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.scope.ActivityScope
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.DummyDependency
import dagger.Module
import dagger.Provides

// This is SubComponent Module
/**
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un- scoped but cannot have with different scopes
 */
@Module
class DummyDependencyModule {

    @ActivityScope
    @Provides
    fun provideDummyDependency(context: Context): DummyDependency {
        return DummyDependency(context)
    }

}