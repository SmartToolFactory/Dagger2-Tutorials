package com.smarttoolfactory.tutorial6_3subcomponentfactory.di

import android.content.SharedPreferences
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.scope.FragmentScope
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.MySharedPreferences
import dagger.Module
import dagger.Provides

/**
 * This is SubComponent Module of [ToastAndPreferencesSubComponent] in this example
 * A module can be used in multiple components
 */
@Module
class MySharedPreferencesModule {

    @FragmentScope
    @Provides
    fun provideMySharedPreference(sharedPreferences: SharedPreferences): MySharedPreferences {
        return MySharedPreferences(sharedPreferences)
    }
}