package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;


import android.content.Context;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.MainActivity;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.MyFragment;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.SecondActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {ToastMakerModule.class})
public interface ToastMakerSubComponent {

    void inject(MyFragment myFragment);

    void inject(SecondActivity secondActivity);

    @Subcomponent.Builder
    interface Builder {

        ToastMakerSubComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}
