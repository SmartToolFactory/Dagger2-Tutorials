package com.example.tutorial5_2dagger_android_subcomponents.di;

import android.content.Context;

import com.example.tutorial5_2dagger_android_subcomponents.MainActivity;
import com.example.tutorial5_2dagger_android_subcomponents.ToastMaker;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ToastMakerModule {

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
