package com.example.tutorial4_4componentbuildersmultiplemodules.di

import android.app.Application
import com.example.tutorial4_4componentbuildersmultiplemodules.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModuleWithBind::class,
    ToastMakerModule::class,
    SensorControllerModule::class])
interface AppComponentWithBind {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        fun build(): AppComponentWithBind

        // @BindsInstance replaces Builder appModule(AppModule appModule)
        // And removes Constructor with Application AppModule(Application)
        @BindsInstance
        fun application(application: Application): Builder
    }
}