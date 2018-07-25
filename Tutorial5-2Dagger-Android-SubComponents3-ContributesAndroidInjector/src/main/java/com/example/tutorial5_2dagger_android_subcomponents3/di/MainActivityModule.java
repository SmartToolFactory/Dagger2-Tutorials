package com.example.tutorial5_2dagger_android_subcomponents3.di;

import android.content.Context;


import com.example.tutorial5_2dagger_android_subcomponents3.MainActivity;
import com.example.tutorial5_2dagger_android_subcomponents3.ToastMaker;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {

    /*
    NOTE: This can only be MainActivity(AndroidInjector<T>), Activity does not work
     */
    @Binds
    abstract Context bindContext(MainActivity mainActivity);

    @ActivityScope
    @Provides
    public static ToastMaker provideToastMaker(Context context) {
        return new ToastMaker(context);
    }
}
