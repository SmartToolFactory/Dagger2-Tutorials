package com.smarttoolfactory.tutorial8_3daggerhilt_definecomponent

import android.app.Application
import com.smarttoolfactory.tutorial8_3daggerhilt_definecomponent.di.AppComponent
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Provider

@HiltAndroidApp
class MyApplication : Application() {

//    private val appComponentProvider by lazy {
//        Provider<AppComponent.Builder> {
//
//        }
//    }

    val appComponent by lazy {
//        appComponentProvider.get().application(this).build()

    }

}