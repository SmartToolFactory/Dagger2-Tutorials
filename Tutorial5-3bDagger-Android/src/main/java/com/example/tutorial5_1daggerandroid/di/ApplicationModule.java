package com.example.tutorial5_1daggerandroid.di;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.tutorial5_1daggerandroid.MainActivity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ToastMakerSubComponent.class})
public abstract class ApplicationModule {

    private static Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    static SharedPreferences provideSharedPreferences() {
        System.out.println("ApplicationModule context: " + context);
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityFactory(ToastMakerSubComponent.Builder builder);
}