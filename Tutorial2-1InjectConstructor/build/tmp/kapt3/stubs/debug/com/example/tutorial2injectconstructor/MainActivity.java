package com.example.tutorial2injectconstructor;

import java.lang.System;

/**
 * This tutorial shows that objects can be injected via constructor injection. If an object
 * can be created via constructor, it should be selected instead of @Provides.
 *
 * @Inject calls this constructor of MySharedPreferences class after injecting SharedPreferences to it
 *
 * @Singleton or any annotation before constructor of object makes it Singleton
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/example/tutorial2injectconstructor/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mySharedPreferences", "Lcom/example/tutorial2injectconstructor/model/MySharedPreferences;", "getMySharedPreferences", "()Lcom/example/tutorial2injectconstructor/model/MySharedPreferences;", "setMySharedPreferences", "(Lcom/example/tutorial2injectconstructor/model/MySharedPreferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Tutorial2-1InjectConstructor_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.example.tutorial2injectconstructor.model.MySharedPreferences mySharedPreferences;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tutorial2injectconstructor.model.MySharedPreferences getMySharedPreferences() {
        return null;
    }
    
    public final void setMySharedPreferences(@org.jetbrains.annotations.NotNull()
    com.example.tutorial2injectconstructor.model.MySharedPreferences p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public MainActivity() {
        super();
    }
}