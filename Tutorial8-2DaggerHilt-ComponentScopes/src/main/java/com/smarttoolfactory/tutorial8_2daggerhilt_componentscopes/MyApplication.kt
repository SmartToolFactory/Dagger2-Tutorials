package com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}