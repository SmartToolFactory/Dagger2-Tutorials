//package com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.main
// TODO This is not required with Hilt unlike Tutorial 6-4
//import android.content.SharedPreferences
//import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model.MySharedPreferences
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.FragmentComponent
//import dagger.hilt.android.scopes.FragmentScoped
//
//
//@InstallIn(FragmentComponent::class)
//@Module
//class SecondFragmentModule {
//
//
//    @FragmentScoped
//    @Provides
//    fun provideMySharedPreference(sharedPreferences: SharedPreferences): MySharedPreferences {
//        return MySharedPreferences(sharedPreferences)
//    }
//
//}