package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.main

import android.content.SharedPreferences
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.scope.FragmentScope
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model.MySharedPreferences
import dagger.Module
import dagger.Provides

@Module
object FirstFragmentModule {

    @JvmStatic
    @FragmentScope
    @Provides
    fun provideMySharedPreference(sharedPreferences: SharedPreferences): MySharedPreferences {
        return MySharedPreferences(sharedPreferences)
    }

}