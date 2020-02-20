package com.example.tutorial4_2subcomponents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial4_2subcomponents.di.ActivityModule;
import com.example.tutorial4_2subcomponents.model.MySharedPreferences;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    // Injected from ApplicationModule
    @Inject
    SharedPreferences mSharedPreferences;

    // Injected via Constructor injection, without @Singleton, it injects new instance after rotation
    @Inject
    MySharedPreferences mMySharedPreferences;

    // Injected from ActivityModule
    @Inject
    ToastMaker toastMaker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication())
                .getApplicationComponent()
                .newActivitySubComponent(new ActivityModule(this))
                .inject(this);


        toastMaker.showToast("Hello World");

        mMySharedPreferences.putData("data", 10);

        // Only SharedPreferences object with @Singleton is the same each time after rotation

        System.out.println("ToastMaker: " + toastMaker
                + ", mMySharedPreferences: " + mMySharedPreferences
                + ", mSharedPreferences: " + mSharedPreferences);

        int val = mMySharedPreferences.getData("data");
        Toast.makeText(this, "Data: " + val, Toast.LENGTH_SHORT).show();
    }
}
