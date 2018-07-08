package com.example.tutorial1basics3.di;

import com.example.tutorial1basics3.MainActivity;
import com.example.tutorial1basics3.MyApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppContextModule.class})
public interface AppContextComponent {
    void inject(MainActivity mainActivity);
}
