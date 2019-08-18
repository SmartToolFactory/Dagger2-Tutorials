package com.example.tutorial5_2dagger_android_subcomponents2.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.tutorial5_2dagger_android_subcomponents2.MainActivity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ToastMakerSubComponent.class})
public abstract class ApplicationModule {


    /*
        Converts Application from ApplicationComponent.Builder  Builder application(Application application)
        method into Application Context
     */
    // @Binds returns interface or abstract from implementation

/*    @Binds
    public abstract Context bindContext(Application application);*/


    @Provides
    @Singleton
    static SharedPreferences provideSharedPreferences(Application application) {
        System.out.println("ApplicationModule context: " + application);
        return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
    }

     /*
      *  NOTE: This is same as adding void inject(MainActivity mainActivity) to SubComponent as in
      *  non dagger-android, and can be removed using
      *  @ContributesAndroidInjector if SubComponent and it's Builder has NO methods
      */

    // 🔥 Injects ToastMakerSubComponent objects to MainActivity
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityFactory(ToastMakerSubComponent.Builder builder);
}