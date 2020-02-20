package com.example.tutorial2injectconstructor;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial2injectconstructor.model.MySharedPreferences;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    // Constructor injection
    @Inject
    MySharedPreferences mySharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplicationContext()).getMyComponent().inject(this);

        // @ Inject calls this constructor of MySharedPreferences class after injecting SharedPreferences to it
        // SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PrefName", Context.MODE_PRIVATE);
        // mySharedPreferences = new MySharedPreferences(sharedPreferences);

        System.out.println("MySharedPreferences: " + mySharedPreferences);

        mySharedPreferences.putData("info", 10);

        int data = mySharedPreferences.getData("info");
        Toast.makeText(this, "DATA: " + data, Toast.LENGTH_SHORT).show();
    }


}
