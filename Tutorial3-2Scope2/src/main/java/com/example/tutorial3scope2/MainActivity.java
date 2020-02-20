package com.example.tutorial3scope2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial3scope2.model.MySharedPreferences;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Named("Field")
    @Inject
    MySharedPreferences mySharedPreferences;

    @Inject
    MySharedPreferences mySharedPreferencesConstructor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplicationContext()).getMyComponent().inject(this);

        System.out.println("Field Injected: "+ mySharedPreferences);
        System.out.println("Constructor Injected: "+ mySharedPreferencesConstructor);

    }


}