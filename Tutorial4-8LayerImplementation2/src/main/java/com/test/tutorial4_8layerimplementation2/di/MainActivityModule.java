package com.test.tutorial4_8layerimplementation2.di;


import android.content.Context;

import com.test.tutorial4_8layerimplementation2.MainActivity;
import com.test.tutorial4_8layerimplementation2.di.model.ToastDisplayer;
import com.test.tutorial4_8layerlibrary.di.ActivityScope;

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
    public static ToastDisplayer provideActivityToastMaker(Context context) {
        return new ToastDisplayer(context);
    }
}
