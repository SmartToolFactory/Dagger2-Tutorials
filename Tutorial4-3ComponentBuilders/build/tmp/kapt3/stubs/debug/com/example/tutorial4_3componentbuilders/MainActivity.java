package com.example.tutorial4_3componentbuilders;

import java.lang.System;

/**
 * @BinsIntance annotation binds an object to DaggerAppComponent via
 *
 * @Override
 * public Builder application(Application application) {
 *   this.application = Preconditions.checkNotNull(application);
 *   return this;
 * }
 * method of generated [DaggerAppComponentWithBindsInstance] class.
 *
 * Note that forgetting to add objects, in this example Application, that annotated
 * with @BindsInstance causes
 * java.lang.IllegalStateException: android.app.Application must be set
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/example/tutorial4_3componentbuilders/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Tutorial4-3ComponentBuilders_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public android.content.SharedPreferences sharedPreferences;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final void setSharedPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public MainActivity() {
        super();
    }
}