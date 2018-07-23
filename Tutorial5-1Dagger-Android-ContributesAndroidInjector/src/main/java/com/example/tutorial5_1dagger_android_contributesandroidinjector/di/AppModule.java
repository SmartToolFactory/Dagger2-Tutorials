package com.example.tutorial5_1dagger_android_contributesandroidinjector.di;

import android.app.Application;
import android.content.Context;


import com.example.tutorial5_1dagger_android_contributesandroidinjector.DummyDependency;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;


@Module
public abstract class AppModule {

    @Binds
    public abstract Context bindContext(Application application);

    @Provides
    static DummyDependency provideDummyDependency(Context context) {
        return new DummyDependency(context);
    }

}
