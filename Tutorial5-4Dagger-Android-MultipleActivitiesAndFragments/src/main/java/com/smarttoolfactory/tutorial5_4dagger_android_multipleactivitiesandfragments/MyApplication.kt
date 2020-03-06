package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments

import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.di.AppComponent
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent: AppComponent = DaggerAppComponent
                .builder()
                .application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}