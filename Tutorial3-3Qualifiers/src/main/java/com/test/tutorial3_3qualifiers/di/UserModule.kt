package com.test.tutorial3_3qualifiers.di

import com.test.tutorial3_3qualifiers.model.User
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @Provides method of module should have same scope with component, or both component and module
 * shouldn't have one
 */
@Module
class UserModule {

    @Singleton
    @Provides
    fun provideUser(): User {
        return User()
    }

    @Singleton
    @CustomUser
    @Provides
    fun provideCustomUser(): User {
        return User("CustomUser", "customuser@example.com")
    }

}