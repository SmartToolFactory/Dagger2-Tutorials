package com.example.tutorial3scope1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutorial3scope1.di.DaggerUserComponent;
import com.example.tutorial3scope1.di.UserComponent;
import com.example.tutorial3scope1.model.User;

import javax.inject.Inject;

public class Activity1 extends AppCompatActivity {
    private UserComponent mUserComponent;

    // This User is created each time device is rotated
    // UserComponent is components are self-contained implementations,
    // exiting a scope is as simple as dropping all references to the component instance

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_123);

        getUserComponent().inject(this);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Main User: " + user.hashCode());


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1.this, Activity2.class);
                startActivity(intent);
            }
        });

    }

    public UserComponent getUserComponent() {
        if (mUserComponent == null) {
            mUserComponent = DaggerUserComponent.create();
        }
        return mUserComponent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity1 onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
