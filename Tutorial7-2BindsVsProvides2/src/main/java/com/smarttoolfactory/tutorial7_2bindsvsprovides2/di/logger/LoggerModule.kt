package com.smarttoolfactory.tutorial7_2bindsvsprovides2.di.logger

import android.content.Context
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.model.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * This module generates 2 classes for each item in companion class
 * * 1- LoggerModuleWithProvides_ProvideLoggerFactory
 * * 2- LoggerModuleWithProvides_Companion_ProvideLoggerFactory
 *
 * 🔥 Extra companion class is created if companion object is used instead of object
 * with different module.
 *
 * *3- @Binds methods do not create extra classes in [LoggerModule]
 */
@Module
abstract class LoggerModule {

    @Named("LoggerModuleBindsLogger")
    @Binds
    abstract fun bindLogger(loggerImpl: LoggerImpl): Logger

    @Named("LoggerModuleBindsToaster")
    @Binds
    abstract fun bindToaster(snackerImpl: SnackerImpl): Snacker

    @Named("LoggerModuleBindsSnacker")
    @Binds
    abstract fun bindSnacker(snackerImpl: SnackerImpl): Snacker

    @Module
    companion object {

        @Named("LoggerCompanionModuleProvidesLogger")
        @JvmStatic
        @Provides
        fun provideLogger(loggerImpl: LoggerImpl): Logger {
            return loggerImpl
        }

        @Named("LoggerCompanionModuleProvidesSnacker")
        @JvmStatic
        @Provides
        fun provideSnacker(snackerImpl: SnackerImpl): Snacker {
            return snackerImpl
        }

        @JvmStatic
        @Provides
        fun provideSensorController(context: Context): SensorController {
            return SensorController(context)
        }

    }
}