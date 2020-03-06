package com.example.tutorial5_2dagger_android_subcomponents2.di

import androidx.lifecycle.LifecycleOwner
import com.example.tutorial5_2dagger_android_subcomponents2.SecondActivity
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [LiveObjectModule::class])
interface LiveObjectSubComponent : AndroidInjector<SecondActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SecondActivity>() {

        // It gets concrete type instance from AndroidInjector<T>
/*
            These 2 methods get lifeCycleOwner from SecondActivity
          */
        override fun seedInstance(instance: SecondActivity) {
            lifecycleOwner(instance)
        }

        @BindsInstance
        abstract fun lifecycleOwner(lifecycleOwner: LifecycleOwner): Builder
    }

}