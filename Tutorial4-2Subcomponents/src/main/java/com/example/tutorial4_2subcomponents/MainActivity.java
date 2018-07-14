package com.example.tutorial4_2subcomponents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tutorial4_2subcomponents.di.ActivityModule;
import com.example.tutorial4_2subcomponents.model.MySharedPreferences;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    ToastMaker toastMaker;


    @Inject
    MySharedPreferences mMySharedPreferences;

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

        int val = mMySharedPreferences.getData("data");
        Toast.makeText(this, "Data: " + val, Toast.LENGTH_SHORT).show();
    }
}
