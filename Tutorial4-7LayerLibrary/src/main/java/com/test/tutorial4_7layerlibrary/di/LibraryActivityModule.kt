package com.test.tutorial4_7layerlibrary.di

import android.content.SharedPreferences
import com.test.tutorial4_7layerlibrary.model.MySharedPreferences
import dagger.Module
import dagger.Provides

/**
 * This is SubComponent Module of [LibraryActivitySubComponent] in this example
 * A module can be used in multiple components
 *
 * Sub component and module CAN NOT have different scopes.
 * IMPORTANT: Both can be un- scoped but cannot have with different scopes
 */
@Module
class LibraryActivityModule {


    @ActivityScope
    @Provides
    fun provideMySharedPrefs(sharedPreferences: SharedPreferences): MySharedPreferences {
        return MySharedPreferences(sharedPreferences)
    }
}