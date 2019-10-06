package com.example.tutorial5_2dagger_android_subcomponents.di;

import android.content.Context;

import com.example.tutorial5_2dagger_android_subcomponents.MainActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;


/**
 * SubComponents extend AndroidInjector<MainActivity> for scoped injections.
 * {@link MainActivity} is the class where {@link ToastMakerModule} objects are injected.
 *
 * <p></p>
 * Sub component and @Provides annotated methods inside module CAN NOT not have different scopes.
 * <p></p>
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes
 */
@ActivityScope
@Subcomponent(modules = {ToastMakerModule.class})
public interface ToastMakerSubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
