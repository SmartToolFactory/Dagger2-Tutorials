package com.test.tutorial4_8layerlibrary.di;


import android.content.Context;


import com.test.tutorial4_8layerlibrary.BaseActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {BaseAppModule.class})
public interface BaseSubComponent {

    void inject(BaseActivity baseActivity);

    /*
     Builder is called from Parent Component,
      and parent component is called from scope(Activity, Fragment, etc.)
      */
    @Subcomponent.Builder
    interface Builder {

        BaseSubComponent build();

        /**
         * Passes context to  sub-component modules and removes module chain
         * toastMakerModule(new ToastMakerModule(this) from Activity or Fragment.
         *
         * @param context is injected  to sub-component modules' methods that require a context
         * @return Builder of SubComponent
         */
        @BindsInstance
        Builder context(Context context);
    }
}
