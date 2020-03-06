package com.example.tutorial5_2dagger_android_subcomponents3.di

import javax.inject.Scope

/**
 * Sub component and @Provides annotated methods inside module cannot not have different scopes.
 * IMPORTANT: Both can be unscoped but cannot have with different scopes
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope