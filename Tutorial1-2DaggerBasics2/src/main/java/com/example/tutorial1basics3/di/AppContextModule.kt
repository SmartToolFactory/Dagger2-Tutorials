package com.example.tutorial1basics3.di

import com.example.tutorial1basics3.MyApplication
import com.example.tutorial1basics3.model.SensorController
import com.example.tutorial1basics3.model.User
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppContextModule(private val myApplication: MyApplication) {

    // @Singleton annotation for application object is not necessary since it's already a singleton object of Android
    @Singleton
    @Provides
    fun provideMyApplication(): MyApplication {
        return myApplication
    }

    // This is a singleton object at application level
    @Singleton
    @Provides
    fun provideUser(): User {
        return User()
    }

    // This is NOT a singleton object
    @Provides
    fun provideSensorController(): SensorController {
        return SensorController(myApplication)
    }

}