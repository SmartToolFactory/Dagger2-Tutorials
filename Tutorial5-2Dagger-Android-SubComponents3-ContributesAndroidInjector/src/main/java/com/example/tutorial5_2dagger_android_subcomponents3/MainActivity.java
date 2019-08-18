package com.example.tutorial5_2dagger_android_subcomponents3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Each Activity has it's own module. MainActivity has MainActivityModule, SecondActivity has
 * SecondActivityModule with @ActivityScope.
 * <p>
 * </p>
 * Each object injected from module only lives through lifecycle of Activities.
 * When an Activity is rotated new ToastMaker object is created for both activities.
 */
public class MainActivity extends DaggerAppCompatActivity {

    // Injected from AppModule with @Singleton
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from MainActivity SubComponent Module with @ActivityScope
    @Inject
    ToastMaker toastMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("🎃 MainActivity toastMaker: " + toastMaker);

        toastMaker.showToast("sharedPreferences " + sharedPreferences);


        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}