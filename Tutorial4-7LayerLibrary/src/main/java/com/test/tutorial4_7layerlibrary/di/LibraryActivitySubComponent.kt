package com.test.tutorial4_7layerlibrary.di

import android.content.Context
import com.test.tutorial4_7layerlibrary.LibraryActivity
import dagger.BindsInstance
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = [LibraryActivityModule::class])
interface LibraryActivitySubComponent {


    fun inject(secondActivity: LibraryActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): LibraryActivitySubComponent
        @BindsInstance
        fun context(context: Context): Builder
    }
}