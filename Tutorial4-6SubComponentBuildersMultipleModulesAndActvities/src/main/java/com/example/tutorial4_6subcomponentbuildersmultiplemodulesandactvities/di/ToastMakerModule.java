package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di;


import android.content.Context;


import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.ToastMaker;

import dagger.Module;
import dagger.Provides;

// This is SubComponent Module

@Module
public class ToastMakerModule {

    @FragmentScope
    @Provides
    ToastMaker provideToastMaker(Context context) {
        return new ToastMaker(context);
    }
}
