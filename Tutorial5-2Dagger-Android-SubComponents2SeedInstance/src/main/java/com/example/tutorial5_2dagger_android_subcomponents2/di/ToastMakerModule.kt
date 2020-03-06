package com.example.tutorial5_2dagger_android_subcomponents2.di

import android.content.Context
import com.example.tutorial5_2dagger_android_subcomponents2.model.ToastMaker
import dagger.Module
import dagger.Provides

/**
 *
 * Sub component and @Provides annotated methods inside module CAN NOT not have different scopes.
 *
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes.
 */
@Module
abstract class ToastMakerModule {

    @Module
    companion object {

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideToastMaker(context: Context): ToastMaker {
            return ToastMaker(context)
        }

    }

    // This method gets Application Context and returns it

/*    @Provides
    static Context provideContext(Application application) {
        return application.getApplicationContext();
    }*/
}