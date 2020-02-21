package com.test.tutorial3_3qualifiers.di

import com.test.tutorial3_3qualifiers.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * @Provides method of module should have same scope with component, or both component and module
 * shouldn't have one
 */
@Singleton
@Component(modules = [UserModule::class])
interface UserComponent {

    fun inject(activity1: MainActivity)

}