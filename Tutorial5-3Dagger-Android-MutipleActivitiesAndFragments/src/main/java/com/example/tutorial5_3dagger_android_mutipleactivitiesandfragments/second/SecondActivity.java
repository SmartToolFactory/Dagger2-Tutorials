package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.second;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.ToastMaker;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SecondActivity extends DaggerAppCompatActivity {

    // Injected from AppModule with @Singleton
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from SecondActivityModule with @ActivityScope
    @Inject
    ToastMaker toastMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("🚙 SecondActivity toastMaker: " + toastMaker);
        System.out.println("🚙 SecondActivity sharedPreferences: " + sharedPreferences);


        toastMaker.showToast("SecondActivity SharedPreferences: " + sharedPreferences);

        TextView textView = findViewById(R.id.text_view);

        textView.setText("ToastMaker: " + toastMaker + "\n sharedPreferences: " + sharedPreferences);

    }
}
