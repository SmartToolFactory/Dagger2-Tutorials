package com.example.tutorial5_2dagger_android_subcomponents3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SecondActivity extends DaggerAppCompatActivity {

    // Injected from ApplicationModule
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from SecondActivity SubComponent Module
    @Inject
    ToastMaker toastMaker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastMaker.showToast("sharedPreferences " + sharedPreferences);
    }
}
