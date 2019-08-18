package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;


import android.content.Context;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.MyFragment;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.SecondActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * This is a SubComponent with 2 modules {@link ToastMakerModule} and {@link MySharedPreferencesModule}
 * Used for injecting objects provided by these modules to activity{@link com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.MainActivity}
 * and fragment({@link MyFragment})
 *
 * <p></p>
 * Sub component and module must not have different scopes.
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes
 *
 * <p></p>
 * !!! Only 1 Component can be injected to an Activity, Fragment or Object
 */

@FragmentScope
@Subcomponent(modules = {ToastMakerModule.class, MySharedPreferencesModule.class})
public interface ToastAndPreferencesSubComponent {

    // !!! IMPORTANT: Only one Component can be injected to an Object

    void inject(MyFragment myFragment);

    void inject(SecondActivity secondActivity);

    @Subcomponent.Builder
    interface Builder {

        ToastAndPreferencesSubComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}
