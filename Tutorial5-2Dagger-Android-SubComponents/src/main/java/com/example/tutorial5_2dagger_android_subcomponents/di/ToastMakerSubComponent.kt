package com.example.tutorial5_2dagger_android_subcomponents.di

import com.example.tutorial5_2dagger_android_subcomponents.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * SubComponents extend AndroidInjector<MainActivity> for scoped injections.
 * [MainActivity] is the class where [ToastMakerModule] objects are injected.
 *
 *
 *
 * Sub component and @Provides annotated methods inside module CAN NOT not have different scopes.
 *
 *
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes
</MainActivity> */
@ActivityScope
@Subcomponent(modules = [ToastMakerModule::class])
interface ToastMakerSubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}