package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.main

import android.content.SharedPreferences
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.scope.FragmentScope
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.MySharedPreferences
import dagger.Module
import dagger.Provides

/**
 * Scope of @ContributesAndroidInjector methods and their modules should be same.
 * Otherwise app returns HAS CONFLICTING SCOPES error
 */

@Module
object MyFragmentModule {

    @JvmStatic
    @FragmentScope
    @Provides
    fun provideMySharedPreference(sharedPreferences: SharedPreferences): MySharedPreferences {
        return MySharedPreferences(sharedPreferences)
    }

}