package com.example.tutorial3scope1.di

import com.example.tutorial3scope1.Activity1
import com.example.tutorial3scope1.Activity2
import com.example.tutorial3scope1.Activity3
import com.example.tutorial3scope1.Activity4
import dagger.Component

/**
 * @Provides method of module should have same scope with component, or both component and module
 * shouldn't have one
 */
@ActivityScope
@Component(modules = [UserModule::class])
interface UserComponent {

    fun inject(activity1: Activity1)
    fun inject(activity2: Activity2)
    fun inject(activity3: Activity3)
    fun inject(activity4: Activity4)
}