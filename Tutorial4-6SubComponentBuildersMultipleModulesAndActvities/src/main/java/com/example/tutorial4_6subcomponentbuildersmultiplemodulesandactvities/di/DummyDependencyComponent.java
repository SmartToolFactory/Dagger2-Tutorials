package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;

import android.content.Context;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.MainActivity;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.SecondActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {DummyDependencyModule.class})
public interface DummyDependencyComponent {

    void inject(MainActivity mainActivity);

    void inject(SecondActivity secondActivity);

    @Subcomponent.Builder
    interface Builder {

        DummyDependencyComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}
