package com.example.tutorial5_1dagger_android_contributesandroidinjector

import com.example.tutorial5_1dagger_android_contributesandroidinjector.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}