package com.example.tutorial5_1dagger_android.di;


import android.app.Activity;
import android.content.Context;

import com.example.tutorial5_1dagger_android.MainActivity;
import com.example.tutorial5_1dagger_android.ToastMaker;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;


@Module
public abstract class ToastMakerModule {

    @ActivityScope
    @Provides
    static ToastMaker provideToastMaker(Context context) {
        System.out.println("ToastMakerModule context: " + context);
        return new ToastMaker(context);
    }

    // This method gets Application Context and returns it
/*    @Provides
    static Context provideContext(Application application) {
        return application.getApplicationContext();
    }*/

}