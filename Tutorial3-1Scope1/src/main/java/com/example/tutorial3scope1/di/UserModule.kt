package com.example.tutorial3scope1.di

import com.example.tutorial3scope1.model.User
import dagger.Module
import dagger.Provides

/**
 * @Provides method of module should have same scope with component, or both component and module
 * shouldn't have one.
 *
 * If it has a gloabl/application level scope then it's generated as Singleton object.
 * Without scope even it's a ApplicationModule objects are re-created
 */
@Module
class UserModule {

    @ActivityScope
    @Provides
    fun provideUser(): User {
        return User()
    }

}