package com.test.tutorial4_7layerimplementation.di

import com.test.tutorial4_7layerimplementation.MainActivity
import com.test.tutorial4_7layerlibrary.di.ActivityScope
import com.test.tutorial4_7layerlibrary.di.BaseAppComponent
import dagger.Component

@ActivityScope
@Component(
        dependencies = [BaseAppComponent::class],
        modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

//    @Component.Builder
//    interface Builder {
//
//        @BindsInstance
//        fun context(str: String): Builder
//
//        fun build(): MainActivityComponent
//    }

}