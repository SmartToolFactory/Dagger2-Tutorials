package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;

import android.content.Context;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.DummyDependency;

import dagger.Module;
import dagger.Provides;

// This is SubComponent Module

@Module
public class DummyDependencyModule {

    @ActivityScope
    @Provides
    DummyDependency provideDummyDependency(Context context) {
        return  new DummyDependency(context);
    }

}
