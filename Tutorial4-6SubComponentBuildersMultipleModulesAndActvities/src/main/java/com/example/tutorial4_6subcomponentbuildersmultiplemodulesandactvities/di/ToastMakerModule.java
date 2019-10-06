package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;


import android.content.Context;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.ToastMaker;

import dagger.Module;
import dagger.Provides;

/**
 * This is SubComponent Module of {@link ToastAndPreferencesSubComponent} in this example
 * A module can be used in multiple components
 *
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un- scoped but cannot have with different scopes
 */


@Module
public class ToastMakerModule {

    @FragmentScope
    @Provides
    ToastMaker provideToastMaker(Context context) {
        return new ToastMaker(context);
    }
}
