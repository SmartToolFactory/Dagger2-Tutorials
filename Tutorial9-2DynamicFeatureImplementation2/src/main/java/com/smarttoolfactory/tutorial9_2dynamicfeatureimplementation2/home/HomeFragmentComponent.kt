package com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.home

import android.app.Application
import com.smarttoolfactory.tutorial9_2core.di.BaseFragmentComponent
import com.smarttoolfactory.tutorial9_2core.di.CoreComponent
import com.smarttoolfactory.tutorial9_2core.di.scope.FragmentScope
import dagger.BindsInstance
import dagger.Component


@FragmentScope
@Component(dependencies = [CoreComponent::class],
        modules = [HomeFragmentModule::class])
interface HomeFragmentComponent : BaseFragmentComponent<HomeFragment> {

    @Component.Factory
    interface Factory {

        fun create(coreComponent: CoreComponent,
                   homeFragmentModule: HomeFragmentModule,
                   @BindsInstance application: Application): HomeFragmentComponent

    }
}