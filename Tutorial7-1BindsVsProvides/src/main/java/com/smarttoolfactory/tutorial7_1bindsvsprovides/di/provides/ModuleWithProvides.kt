package com.smarttoolfactory.tutorial7_1bindsvsprovides.di.provides

import com.smarttoolfactory.tutorial7_1bindsvsprovides.model.Logger
import com.smarttoolfactory.tutorial7_1bindsvsprovides.model.LoggerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ModuleWithProvides {

    @Named("provides")
    @Provides
    fun provideLogger(loggerImpl: LoggerImpl): Logger {
        return  loggerImpl
    }
}