package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.second;

import android.content.Context;


import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di.ActivityScope;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.second.SecondActivity;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.ToastMaker;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class SecondActivityModule {

    /*
    NOTE: This can only be SecondActivity(AndroidInjector<T>), Activity does not work
     */
    @Binds
    abstract Context bindContext(SecondActivity activity);

    @ActivityScope
    @Provides
    public static ToastMaker provideToastMaker(Context context) {
        return new ToastMaker(context);
    }
}
