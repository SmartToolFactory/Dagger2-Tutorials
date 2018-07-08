package com.example.tutorial1daggerbasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tutorial1daggerbasics.model.MyExample;

import java.util.Date;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

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
    }
}
