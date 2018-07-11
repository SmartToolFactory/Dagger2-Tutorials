package com.example.tutorial2injectconstructor.di;

import com.example.tutorial2injectconstructor.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = SharedPreferencesModule.class)
@Singleton
public interface MyComponent {
    void inject(MainActivity mainActivity);
}