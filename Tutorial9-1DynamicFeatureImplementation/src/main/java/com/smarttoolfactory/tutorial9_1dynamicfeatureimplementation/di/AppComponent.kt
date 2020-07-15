package com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di

import android.app.Application
import android.content.SharedPreferences
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.ToastMaker
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {


    fun provideToastMaker(): ToastMaker
    fun provideSharedPreferences(): SharedPreferences

    fun inject(application: Application)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    // Types that can be retrieved from the graph
    fun mainActivityComponentFactory(): MainActivitySubComponent.Factory
}