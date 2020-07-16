package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.di

import android.app.Application
import com.smarttoolfactory.tutorial9_2core.di.BaseActivityComponent
import com.smarttoolfactory.tutorial9_2core.di.CoreComponent
import com.smarttoolfactory.tutorial9_2core.di.scope.ActivityScope
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.MainActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(dependencies = [CoreComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent:BaseActivityComponent<MainActivity> {

    @Component.Factory
    interface Factory {

        fun create(coreComponent: CoreComponent,
                   mainActivityModule: MainActivityModule,
                   @BindsInstance application: Application): MainActivityComponent

    }
}