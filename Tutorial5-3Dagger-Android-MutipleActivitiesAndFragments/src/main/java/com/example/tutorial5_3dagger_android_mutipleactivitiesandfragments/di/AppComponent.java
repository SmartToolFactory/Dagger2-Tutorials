package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di;

import android.app.Application;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MyApplication;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MyFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/*
 * Differences between AppComponent of dagger-android and regular dagger:
 *
  * 1- Binds AndroidSupportInjectionModule.class in modules
 *  2- Extends AndroidInjector<MyApplication>
 *  3- Does not have sub-component builder to inject to classes inside sub-component
 *  DummyDependencyComponent.Builder dummyDependencyBuilder(); is not required in app component
 */

@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityContributorModule.class})

/*
 * ActivityContributorModule defines which Activities will have which modules and inject objects
 * If an Activity has any fragments it should add them via FragmentContributorModule with @ContributesAndroidInjector
 * @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentContributorModule.class})
 */

@Singleton
public interface AppComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MyApplication myApplication);
}