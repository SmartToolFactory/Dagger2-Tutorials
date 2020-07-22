//package com.smarttoolfactory.feature_hilt_camera.di
//
//@FeatureScope
//@Component(
//        dependencies = [CoreComponent::class]
//)
//interface CameraComponent {
//
//    fun inject(cameraFragment1: CameraFragment1)
//    fun inject(cameraFragment2: CameraFragment2)
//
//    @Component.Factory
//    interface Factory {
//
//        fun create(coreComponent: CoreComponent,
//                   cameraModule: CameraModule,
//                   @BindsInstance application: Application): CameraComponent
//
//    }
//
//}