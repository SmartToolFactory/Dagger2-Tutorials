package com.smarttoolfactory.gallery.di

import com.smarttoolfactory.gallery.GalleryActivity
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di.AppComponent
import dagger.Component

@GalleryScope
@Component(
        dependencies = [AppComponent::class],
        modules = [GalleryModule::class])
interface GalleryComponent {
    fun inject(galleryActivity: GalleryActivity)
}