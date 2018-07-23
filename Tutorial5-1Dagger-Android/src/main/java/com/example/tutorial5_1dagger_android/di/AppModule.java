package com.example.tutorial5_1dagger_android.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.tutorial5_1dagger_android.DummyDependency;
import com.example.tutorial5_1dagger_android.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;


@Module(subcomponents = MainActivitySubComponent.class)
public abstract class AppModule {

    @Binds
    public abstract Context bindContext(Application application);

    @Provides
    static DummyDependency provideDummyDependency(Context context) {
        return new DummyDependency(context);
    }

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindInjectorFactory(MainActivitySubComponent.Builder builder);

}


