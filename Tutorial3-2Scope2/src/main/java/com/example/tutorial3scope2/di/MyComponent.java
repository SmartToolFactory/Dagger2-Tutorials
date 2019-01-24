package com.example.tutorial3scope2.di;



import com.example.tutorial3scope2.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = SharedPreferencesModule.class)
@Singleton
public interface MyComponent {
    void inject(MainActivity mainActivity);
}