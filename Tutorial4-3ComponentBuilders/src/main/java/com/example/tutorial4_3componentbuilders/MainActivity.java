package com.example.tutorial4_3componentbuilders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getAppComponent().inject(this);
       // ((MyApplication) getApplication()).getAppComponentWithBindsInstance().inject(this);

        System.out.println("MainActivity mSharedPreferences: "+ mSharedPreferences);

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("data", 13);
        editor.apply();

        int data = mSharedPreferences.getInt("data", 0);
        Toast.makeText(this, "Data: " + data, Toast.LENGTH_SHORT).show();
    }
}
