package com.example.tutorial1daggerbasics.di;

import com.example.tutorial1daggerbasics.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MyExampleModule.class})
public interface MyExampleComponent {
    void inject(MainActivity mainActivity);
}
