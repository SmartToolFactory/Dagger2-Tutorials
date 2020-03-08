package com.smarttoolfactory.tutorial7_1bindsvsprovides.di.binds

import com.smarttoolfactory.tutorial7_1bindsvsprovides.model.Logger
import com.smarttoolfactory.tutorial7_1bindsvsprovides.model.LoggerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class ModuleWithBinds {

    @Named("binds")
    @Binds
    abstract fun bindLogger(loggerImpl: LoggerImpl): Logger

}