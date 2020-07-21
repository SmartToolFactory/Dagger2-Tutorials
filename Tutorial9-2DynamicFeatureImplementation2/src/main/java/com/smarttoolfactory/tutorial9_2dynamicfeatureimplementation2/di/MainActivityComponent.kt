package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di

import android.app.Application
import com.smarttoolfactory.tutorial9_2core.di.BaseActivityComponent
import com.smarttoolfactory.tutorial9_2core.di.CoreComponent
import com.smarttoolfactory.tutorial9_2core.di.scope.ActivityScope
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.MainActivity
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.main.MainFragmentSubComponent
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.MainActivityObject
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.model.ToastMaker
import dagger.BindsInstance
import dagger.Component

/**
 * [FragmentSubComponentsModule] is for adding Subcomponent
 *
 */
@ActivityScope
@Component(
        dependencies = [CoreComponent::class],
        modules = [
            FragmentSubComponentsModule::class,
            MainActivityModule::class]
)
interface MainActivityComponent : BaseActivityComponent<MainActivity> {

    /*
        🔥🔥🔥 Provision methods to provide the dependencies from [MainActivityModule] to components that
        depends on MainActivityComponent.

        PhotoComponent depends on this component
     */
    fun provideToastMaker(): ToastMaker
    fun provideMainActivityDependency(): MainActivityObject

    /**
     * Subcomponent of this component
     */
    fun mainFragmentFactory(): MainFragmentSubComponent.Factory

    @Component.Factory
    interface Factory {

        fun create(coreComponent: CoreComponent,
                   mainActivityModule: MainActivityModule,
                   @BindsInstance application: Application): MainActivityComponent

    }
}