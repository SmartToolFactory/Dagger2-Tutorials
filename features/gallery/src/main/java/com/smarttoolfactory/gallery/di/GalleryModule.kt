package com.smarttoolfactory.gallery.di

import android.app.Application
import android.content.Context
import com.smarttoolfactory.gallery.GalleryViewer
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.DummyDependency
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [GalleryBindModule::class])
class GalleryModule {

    @GalleryScope
    @Provides
    fun provideGalleryViewer(context: Context) = GalleryViewer(context)

    @GalleryScope
    @Provides
    fun provideDummyDependency(application: Application) = DummyDependency(application)
}

@Module
abstract class GalleryBindModule {
    @Binds
    abstract fun bindContext(application: Application): Context

}
