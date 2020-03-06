package com.example.tutorial5_2dagger_android_subcomponents3.di

import android.app.Application
import com.example.tutorial5_2dagger_android_subcomponents3.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*
 * Differences between AppComponent of dagger-android and regular dagger:
 *
 * 1- Binds AndroidSupportInjectionModule.class in modules
 * 2- Extends AndroidInjector<MyApplication>
 * 3- Does not have sub-component builder to inject to classes inside sub-component
 */
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityContributorModule::class])
@Singleton
interface AppComponent : AndroidInjector<MyApplication> {
  
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
    
}