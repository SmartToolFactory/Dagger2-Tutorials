package com.example.tutorial5_2dagger_android_subcomponents2.di

import android.content.Context
import com.example.tutorial5_2dagger_android_subcomponents2.MainActivity
import dagger.BindsInstance
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
 * IMPORTANT: Both can be un-scoped but cannot have with different scopes.
</MainActivity> */
@ActivityScope
@Subcomponent(modules = [ToastMakerModule::class])
interface ToastMakerSubComponent : AndroidInjector<MainActivity> {
   
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {

        // It gets concrete type instance from AndroidInjector<T>
        /*
          These 2 methods get Context from MainActivity
        */
        override fun seedInstance(instance: MainActivity) {
            context(instance)
        }

        @BindsInstance
        abstract fun context(context: Context): Builder
    }
}