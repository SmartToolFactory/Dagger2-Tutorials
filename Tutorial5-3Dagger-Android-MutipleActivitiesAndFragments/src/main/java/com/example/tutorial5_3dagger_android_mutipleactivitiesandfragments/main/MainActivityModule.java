package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main;

import android.content.Context;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di.ActivityScope;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main.MainActivity;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.ToastMaker;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {

    /*
    NOTE: This can only be MainActivity(AndroidInjector<T>), Activity does not work
     */
    @Binds
    abstract Context bindContext(MainActivity activity);

    @ActivityScope
    @Provides
    public static ToastMaker provideToastMaker(Context context) {
        return new ToastMaker(context);
    }
}
