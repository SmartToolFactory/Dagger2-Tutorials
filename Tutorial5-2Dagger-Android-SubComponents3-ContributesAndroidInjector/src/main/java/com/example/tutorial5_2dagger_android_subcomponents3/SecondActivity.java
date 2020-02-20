package com.example.tutorial5_2dagger_android_subcomponents3;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SecondActivity extends DaggerAppCompatActivity {

    // Injected from AppModule with @Singleton
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from SecondActivity SubComponent Module with @ActivityScope
    @Inject
    ToastMaker toastMaker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("👀 SecondActivity toastMaker: " + toastMaker);


        toastMaker.showToast("sharedPreferences " + sharedPreferences);
    }
}
