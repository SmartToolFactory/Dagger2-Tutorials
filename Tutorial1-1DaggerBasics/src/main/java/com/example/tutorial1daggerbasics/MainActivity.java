package com.example.tutorial1daggerbasics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutorial1daggerbasics.model.MyExample;

import java.util.Date;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    // Note: This is a singleton object, MainActivity injects same object after device is rotated!
    // Note2: it's a singleton object if and only it's in a Application level module and annotated with @Singleton
    @Inject
    MyExample mMyExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dateTextView = findViewById(R.id.tv_date);

        ((MyApplication) getApplication())
                .getMyComponent()
                .inject(MainActivity.this);

        dateTextView.setText((new Date(mMyExample.getDate())).toString());

        System.out.println("MyExample: " + mMyExample);

        Toast.makeText(this, "MyExample: " + mMyExample, Toast.LENGTH_SHORT).show();
    }
}
