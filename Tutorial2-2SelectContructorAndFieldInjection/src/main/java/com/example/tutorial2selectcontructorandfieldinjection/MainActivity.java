package com.example.tutorial2selectcontructorandfieldinjection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial2selectcontructorandfieldinjection.model.MySharedPreferences;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Named("Field")
    @Inject
    MySharedPreferences mySharedPreferences;

    @Inject
    MySharedPreferences mySharedPreferencesConstructor;

    private int data1, data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplicationContext()).getMyComponent().inject(this);

        // @ Inject calls this constructor of MySharedPreferences class after injecting SharedPreferences to it
        // SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PrefName", Context.MODE_PRIVATE);
        // mySharedPreferences = new MySharedPreferences(sharedPreferences);


        System.out.println("Field Injected: "+ mySharedPreferences);
        System.out.println("Constructor Injected: "+ mySharedPreferencesConstructor);

        mySharedPreferences.putData("info", 0);
        mySharedPreferencesConstructor.putData("info", 0);

        data1 = mySharedPreferences.getData("info");
        data2 = mySharedPreferencesConstructor.getData("info");

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        final TextView textView1 = findViewById(R.id.textView1);
        final TextView textView2 = findViewById(R.id.textView2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data1 += 3;
                mySharedPreferences.putData("info", data1);
                textView1.setText("Field injected: " + mySharedPreferences.getData("info"));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data2 += 5;
                mySharedPreferencesConstructor.putData("info", data2);
                textView2.setText("Constructor injected: " + mySharedPreferencesConstructor.getData("info"));
            }
        });
    }


}