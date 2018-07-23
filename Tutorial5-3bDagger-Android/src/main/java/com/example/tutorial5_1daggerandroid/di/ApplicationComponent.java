package com.example.tutorial5_1daggerandroid.di;


import com.example.tutorial5_1daggerandroid.MainActivity;
import com.example.tutorial5_1daggerandroid.MyApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.AndroidSupportInjectionModule;

// This is parent component
@Component(modules = {ApplicationModule.class, AndroidSupportInjectionModule.class})
@Singleton
public interface ApplicationComponent extends AndroidInjector<MyApplication> {

}