package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di

import android.content.SharedPreferences
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.scope.FragmentScope
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.MySharedPreferences
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