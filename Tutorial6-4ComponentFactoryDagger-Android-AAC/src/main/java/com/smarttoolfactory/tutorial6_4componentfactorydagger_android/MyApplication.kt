package com.smarttoolfactory.tutorial6_4componentfactorydagger_android

import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.AppComponent
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent: AppComponent = DaggerAppComponent.factory().create(this)
        appComponent.inject(this)
        return appComponent
    }
}