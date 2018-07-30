package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}