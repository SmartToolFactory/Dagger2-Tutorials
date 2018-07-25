package com.example.tutorial5_2dagger_android_subcomponents3;

import android.content.SharedPreferences;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    // Injected from ApplicationModule
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from ToastMaker SubComponent Module
    @Inject
    ToastMaker toastMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastMaker.showToast("sharedPreferences " + sharedPreferences);


    }
}