package com.smarttoolfactory.gallery.di

import android.app.Application
import com.smarttoolfactory.gallery.GalleryViewer
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.model.DummyDependency
import dagger.Module
import dagger.Provides

@Module
class GalleryModule {

    @GalleryScope
    @Provides
    fun provideGalleryViewer() = GalleryViewer()

    @GalleryScope
    @Provides
    fun provideDummyDependency(application: Application) = DummyDependency(application)
}