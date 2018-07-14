package com.example.tutorial4_3componentbuilders.di;

import com.example.tutorial4_3componentbuilders.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    // DaggerAppComponent.build() returns this Builder interface

/*    @Component.Builder
    interface Builder {
        AppComponent build();
        Builder appModule(AppModule appModule);
    }*/

}