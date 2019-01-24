package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;

import android.content.Context;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.MainActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;
/**
 * Sub component and module should not have different scopes.
 * IMPORTANT: Both can be unscoped but cannot have with different scopes
 */
@ActivityScope
@Subcomponent(modules = {DummyDependencyModule.class})
public interface DummyDependencyComponent {

    void inject(MainActivity mainActivity);


    // !!! IMPORTANT: Only one Component can be injected to an Object
    // Second Activity  uses ToastAndPreferencesSubComponent already
/*
    void inject(SecondActivity secondActivity);
*/

    // !!! IMPORTANT2: Components scope and Injected objects scope can not be different
    // SensorController is also injected to MainActivity,
    // thus both should have the same scope which is @ActivityScope

    @Subcomponent.Builder
    interface Builder {

        DummyDependencyComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}
