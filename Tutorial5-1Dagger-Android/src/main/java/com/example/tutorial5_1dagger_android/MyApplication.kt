package com.example.tutorial5_1dagger_android

import com.example.tutorial5_1dagger_android.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * DaggerApplication is an abstract class in dagger-android package,
 * the class extends Application class,
 *
 * implements HasActivityInjector, HasBroadcastReceiverInjector,
 * HasContentProviderInjector, HasFragmentInjector, HasServiceInjector
 *
 * and have an abstract method whose implementation should return an AndroidInjector.
 */
class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       val androidInjector = DaggerAppComponent
                .builder()
                .application(this)
                .build()

        androidInjector.inject(this)

        return androidInjector
    }

}