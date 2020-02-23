package com.example.tutorial4_3componentbuilders.di

import android.app.Application
import com.example.tutorial4_3componentbuilders.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModuleWithBindsInstance::class])
interface AppComponentWithBindsInstance {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        fun build(): AppComponentWithBindsInstance

        // @BindsInstance replaces Builder appModule(AppModule appModule)
        // And removes Constructor with Application AppModule(Application)
        @BindsInstance
        fun application(application: Application): Builder

    }
}