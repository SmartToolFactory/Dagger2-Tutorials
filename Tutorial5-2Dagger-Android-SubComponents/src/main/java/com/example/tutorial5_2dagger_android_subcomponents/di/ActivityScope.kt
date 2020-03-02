package com.example.tutorial5_2dagger_android_subcomponents.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 *
 * Sub component and @Provides annotated methods inside module cannot not have different scopes.
 * IMPORTANT: Both can be unscoped but cannot have with different scopes
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope