package com.example.tutorial4_2subcomponents.di;

import com.example.tutorial4_2subcomponents.MainActivity;
import com.example.tutorial4_2subcomponents.ToastMaker;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final MainActivity mainActivity;

    public ActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @ActivityScope
    @Provides
    ToastMaker provideToastMaker() {
        return  new ToastMaker(mainActivity);
    };
}
