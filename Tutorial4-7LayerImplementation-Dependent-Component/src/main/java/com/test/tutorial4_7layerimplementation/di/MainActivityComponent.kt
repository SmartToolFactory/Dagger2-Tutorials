package com.test.tutorial4_7layerimplementation.di

import android.app.Application
import com.test.tutorial4_7layerimplementation.MainActivity
import com.test.tutorial4_7layerlibrary.di.ActivityScope
import com.test.tutorial4_7layerlibrary.di.BaseAppComponent
import dagger.BindsInstance
import dagger.Component

/**
 * This component depends on [BaseAppComponent].
 *
 * * Note: If this component is un-scoped it results a Compile error:
 *  `MainActivityComponent (unscoped) cannot depend on scoped components:`
 *
 * * Note: This component also not have @Singleton component and results Compile error:
 * `This @Singleton component cannot depend on scoped components:`
 */
//@Singleton
@ActivityScope
@Component(
        dependencies = [BaseAppComponent::class],
        modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        fun build(): MainActivityComponent

        @BindsInstance
        fun application(application: Application): Builder
        fun mainActivityModule(module: MainActivityModule): Builder
        fun baseAppComponent(baseAppComponent: BaseAppComponent): Builder

    }

}