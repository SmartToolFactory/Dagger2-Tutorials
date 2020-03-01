package com.example.tutorial2selectcontructorandfieldinjection.model;

import java.lang.System;

/**
 * Here in this model class constructor injection is used as @Inject is added on the constructor.
 * SharedPreferences object is passed from Module to constructor with provideSharedPreferences()
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/tutorial2selectcontructorandfieldinjection/model/MySharedPreferences;", "", "mSharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getData", "", "key", "", "putData", "", "data", "Tutorial2-2SelectContructorAndFieldInjection_debug"})
public final class MySharedPreferences {
    private final android.content.SharedPreferences mSharedPreferences = null;
    
    public final void putData(@org.jetbrains.annotations.Nullable()
    java.lang.String key, int data) {
    }
    
    public final int getData(@org.jetbrains.annotations.Nullable()
    java.lang.String key) {
        return 0;
    }
    
    @javax.inject.Inject()
    public MySharedPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences mSharedPreferences) {
        super();
    }
}