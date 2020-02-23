package com.example.tutorial4_4componentbuildersmultiplemodules.di

import com.example.tutorial4_4componentbuildersmultiplemodules.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ToastMakerModule::class, SensorControllerModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    // DaggerAppComponent.build() returns this Builder interface
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun appModule(appModule: AppModule): Builder
        fun sensorControllerModule(sensorControllerModule: SensorControllerModule): Builder
        fun toastMakerModule(toastMakerModule: ToastMakerModule): Builder
    }
}