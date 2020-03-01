package com.example.tutorial2selectcontructorandfieldinjection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/example/tutorial2selectcontructorandfieldinjection/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "data1", "", "data2", "mySharedPreferences", "Lcom/example/tutorial2selectcontructorandfieldinjection/model/MySharedPreferences;", "mySharedPreferences$annotations", "getMySharedPreferences", "()Lcom/example/tutorial2selectcontructorandfieldinjection/model/MySharedPreferences;", "setMySharedPreferences", "(Lcom/example/tutorial2selectcontructorandfieldinjection/model/MySharedPreferences;)V", "mySharedPreferencesConstructor", "getMySharedPreferencesConstructor", "setMySharedPreferencesConstructor", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Tutorial2-2SelectContructorAndFieldInjection_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences mySharedPreferences;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences mySharedPreferencesConstructor;
    private int data1;
    private int data2;
    private java.util.HashMap _$_findViewCache;
    
    @javax.inject.Named(value = "Field")
    public static void mySharedPreferences$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences getMySharedPreferences() {
        return null;
    }
    
    public final void setMySharedPreferences(@org.jetbrains.annotations.NotNull()
    com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences getMySharedPreferencesConstructor() {
        return null;
    }
    
    public final void setMySharedPreferencesConstructor(@org.jetbrains.annotations.NotNull()
    com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public MainActivity() {
        super();
    }
}