package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.main.MainActivitySubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AppModule of dagger-android with @ContributesAndroidInjector
 * does not declare sub-components inside @Module annotation
 *
 * @Module(subcomponents = {A.class, B.class}) is not used
 */
@Module(subcomponents = [MainActivitySubComponent::class])
abstract class AppModule {

//    @Binds
//    @IntoMap
//    @ClassKey(MainActivity::class)
//    abstract fun bindMainActivityFactory(builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<*>

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun provideSharedPreferences(application: Application): SharedPreferences {
            println("ApplicationModule context: $application")
            return application.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
        }
    }

}