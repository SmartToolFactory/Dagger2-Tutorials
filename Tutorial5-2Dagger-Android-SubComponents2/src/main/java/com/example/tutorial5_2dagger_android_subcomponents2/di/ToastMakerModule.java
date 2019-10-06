package com.example.tutorial5_2dagger_android_subcomponents2.di;


import android.content.Context;


import com.example.tutorial5_2dagger_android_subcomponents2.ToastMaker;

import dagger.Module;
import dagger.Provides;


/**
 * <p></p>
 * Sub component and @Provides annotated methods inside module CAN NOT not have different scopes.
 * <p></p>
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes.
 */
@Module
public abstract class ToastMakerModule {

    @ActivityScope
    @Provides
    static ToastMaker provideToastMaker(Context context) {
        System.out.println("ToastMakerModule context: " + context);
        return new ToastMaker(context);
    }

    // This method gets Application Context and returns it
/*    @Provides
    static Context provideContext(Application application) {
        return application.getApplicationContext();
    }*/

}