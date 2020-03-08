package com.smarttoolfactory.tutorial7_2bindsvsprovides2.di.toaster

import com.smarttoolfactory.tutorial7_2bindsvsprovides2.model.Toaster
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.model.ToasterImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [ToasterProviderModule::class])
abstract class ToasterModule {

    @Named("bindsToaster")
    @Binds
    abstract fun bindToaster(toasterImpl: ToasterImpl): Toaster

}

@Module
object ToasterProviderModule {

    @Named("providesToaster")
    @JvmStatic
    @Provides
    fun provideToaster(toasterImpl: ToasterImpl): Toaster {
        return toasterImpl
    }

}