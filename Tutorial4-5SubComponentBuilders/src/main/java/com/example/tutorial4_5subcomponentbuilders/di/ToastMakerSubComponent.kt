package com.example.tutorial4_5subcomponentbuilders.di

import android.content.Context
import com.example.tutorial4_5subcomponentbuilders.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes
 */
@ActivityScope
@Subcomponent(modules = [ToastMakerModule::class])
interface ToastMakerSubComponent {

    fun inject(mainActivity: MainActivity)
    /*
     Builder is called from Parent Component,
      and parent component is called from scope(Activity, Fragment, etc.)
      */
    @Subcomponent.Builder
    interface Builder {

        fun build(): ToastMakerSubComponent

        /*
         Binds Module's required arguments from lower scope like Activity or Fragment
         Sub Component's Module provider method:
          ToastMaker provideToastMaker(Context context) {return new ToastMaker(context);}
          */
        // Context can be provided from ApplicationModule too
        // This context is MainActivity
        /**
         * Passes context to  sub-component modules and removes module chain
         * toastMakerModule(new ToastMakerModule(this) from Activity or Fragment.
         *
         * @param context is injected  to sub-component modules' methods that require a context
         * @return Builder of SubComponent
         */
        @BindsInstance
        fun context(context: Context): Builder
    }
}