package com.smarttoolfactory.gallery.di

import android.app.Application
import com.smarttoolfactory.gallery.GalleryActivity
import com.smarttoolfactory.tutorial9_1dynamicfeatureimplementation.di.AppComponent
import dagger.BindsInstance
import dagger.Component

@GalleryScope
@Component(
        dependencies = [AppComponent::class],
        modules = [GalleryModule::class])
interface GalleryComponent {

    fun inject(galleryActivity: GalleryActivity)

    // TODO Alternative1 With Builder
//    @Component.Builder
//    interface Builder {
//
//        fun build(): GalleryComponent
//
//        @BindsInstance
//        fun application(application: Application): Builder
//        fun galleryModule(module: GalleryModule): Builder
//
//        fun appComponent(appComponent: AppComponent): Builder
//
//    }

    // TODO Alternative2 With Factory
    @Component.Factory
    interface Factory {

        fun create(appComponent: AppComponent,
                   galleryModule: GalleryModule,
                   @BindsInstance application: Application): GalleryComponent


    }
}