package com.smarttoolfactory.gallery.di

import com.smarttoolfactory.gallery.GalleryViewer
import dagger.Module
import dagger.Provides

@Module
class GalleryModule {

    @GalleryScope
    @Provides
    fun provideGalleryViewer() = GalleryViewer()

//    @GalleryScope
//    @Provides
//    fun provideDummyDependency(application: Application) = DummyDependency(application)
}