package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**
 * Sub component and @Provides annotated methods inside module cannot not have different scopes.
 * IMPORTANT: Both can be unscoped but cannot have with different scopes
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}