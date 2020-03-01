package com.example.tutorial1daggerbasics2;

import java.lang.System;

/**
 * This tutorial displays that provision method in [VehicleComponent] returns [Vehicle].
 *
 * Note: Returned object is not singleton since it's created inside this Activity.
 *
 * Provision method does the same thing with
 * @Inject lateinit var vehicle: Vehicle
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/tutorial1daggerbasics2/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "vehicle", "Lcom/example/tutorial1daggerbasics2/model/Vehicle;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Tutorial1-3ProvisionMethod_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.tutorial1daggerbasics2.model.Vehicle vehicle;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public MainActivity() {
        super();
    }
}