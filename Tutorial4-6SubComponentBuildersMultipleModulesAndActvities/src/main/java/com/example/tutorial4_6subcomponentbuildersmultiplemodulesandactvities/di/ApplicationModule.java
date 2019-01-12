package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {ToastAndPreferencesSubComponent.class, DummyDependencyComponent.class})
public class ApplicationModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

}