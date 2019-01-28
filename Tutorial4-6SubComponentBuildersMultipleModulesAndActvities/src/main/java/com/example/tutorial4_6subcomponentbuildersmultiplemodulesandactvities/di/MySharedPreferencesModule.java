package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;

import android.content.SharedPreferences;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.MySharedPreferences;

import dagger.Module;

/**
 * This is SubComponent Module of {@link ToastAndPreferencesSubComponent} in this example
 * A module can be used in multiple components
 */
@Module
public class MySharedPreferencesModule {

    @FragmentScope
    MySharedPreferences provideMySharedPreference(SharedPreferences sharedPreferences) {
        return new MySharedPreferences(sharedPreferences);
    }
}
