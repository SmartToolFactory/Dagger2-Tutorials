package com.smarttoolfactory.tutorial6_4componentfactorydagger_android.di

import android.app.Application
import com.smarttoolfactory.tutorial6_4componentfactorydagger_android.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityContributorModule::class])
/**
 * Component with @Factory annotation uses create method with params that have
 * @BindsInstance annotation to inject at runtime. And in application class it's called using
 * DaggerAppComponent.factory().create(this)
 * instead of  DaggerAppComponent.builder().application(this).build()
 */
@Singleton
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): AppComponent
    }

    override fun inject(myApplication: MyApplication)
}