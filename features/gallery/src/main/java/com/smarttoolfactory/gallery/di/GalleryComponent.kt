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

    //    @Component.Builder
//    interface Builder {
//
//        fun build(): GalleryComponent
//
////         @BindsInstance replaces Builder appModule(AppModule appModule)
////         And removes Constructor with Application AppModule(Application)
////        @BindsInstance
////        fun application(application: Application): Builder
//
//    }
    @Component.Builder
    interface Builder {

        fun build(): GalleryComponent

        @BindsInstance
        fun application(application: Application): Builder
        fun galleryModule(module: GalleryModule): Builder

        fun appComponent(appComponent: AppComponent): Builder

    }
}