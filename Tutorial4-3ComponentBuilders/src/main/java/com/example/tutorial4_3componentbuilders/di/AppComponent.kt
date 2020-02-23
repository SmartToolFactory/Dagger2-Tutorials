package com.example.tutorial4_3componentbuilders.di

import com.example.tutorial4_3componentbuilders.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    // DaggerAppComponent.build() returns this Builder interface
    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        fun appModule(appModule: AppModule): Builder
    }

}