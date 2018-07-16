package com.example.tutorial4_5subcomponentbuilders.di;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {ToastMakerSubComponent.class})
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        System.out.println("ApplicationModule context: " + context);
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }
}