package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;

import android.content.Context;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.DummyDependency;

import dagger.Module;
import dagger.Provides;

// This is SubComponent Module

/**
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un- scoped but cannot have with different scopes
 */
@Module
public class DummyDependencyModule {

    @ActivityScope
    @Provides
    DummyDependency provideDummyDependency(Context context) {
        return  new DummyDependency(context);
    }

}
