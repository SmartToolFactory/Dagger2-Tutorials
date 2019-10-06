package com.example.tutorial4_5subcomponentbuilders.di;



import android.app.Application;
import android.content.Context;

import com.example.tutorial4_5subcomponentbuilders.MainActivity;
import com.example.tutorial4_5subcomponentbuilders.ToastMaker;

import dagger.Module;
import dagger.Provides;

// This is SubComponent Module


/**
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes
 */
@Module
public class ToastMakerModule {

    @ActivityScope
    @Provides
    ToastMaker provideToastMaker(Context context) {
        System.out.println("ToastMakerModule context: " + context);
        return new ToastMaker(context);
    }
}
