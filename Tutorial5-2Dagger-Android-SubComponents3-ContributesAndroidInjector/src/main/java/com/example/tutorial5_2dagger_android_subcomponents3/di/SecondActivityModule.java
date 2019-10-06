package com.example.tutorial5_2dagger_android_subcomponents3.di;

import android.content.Context;

import com.example.tutorial5_2dagger_android_subcomponents3.MainActivity;
import com.example.tutorial5_2dagger_android_subcomponents3.SecondActivity;
import com.example.tutorial5_2dagger_android_subcomponents3.ToastMaker;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;


/**
 * Scope of @ContributesAndroidInjector methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 */
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
