package com.example.tutorial3scope1.di;


import com.example.tutorial3scope1.MainActivity;
import com.example.tutorial3scope1.SecondActivity;
import com.example.tutorial3scope1.ThirdActivity;

import javax.inject.Singleton;

import dagger.Component;

@ActivityScope
@Component(modules = {UserModule.class})
public interface UserComponent {
    void inject(MainActivity mainActivity);

    void inject(SecondActivity secondActivity);

    void inject(ThirdActivity thirdActivity);
}
