package com.example.tutorial3scope1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.tutorial3scope1.model.User;

import javax.inject.Inject;

public class ThirdActivity extends AppCompatActivity {

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get Application Component
        ((MyApplication) getApplication()).getUserComponent().inject(this);

        // Get Class Component
        // UserComponent daggerUserComponent = DaggerUserComponent.create();
        // TODO NEED to ADD void inject(ThirdActivity thirdActivity); UserComponent
        //daggerUserComponent.inject(this);


        TextView textView = findViewById(R.id.textView);
        textView.setText("Main User: " + user.hashCode());
    }
}
