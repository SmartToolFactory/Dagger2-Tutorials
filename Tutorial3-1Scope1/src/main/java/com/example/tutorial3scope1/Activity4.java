package com.example.tutorial3scope1;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial3scope1.di.UserComponent;
import com.example.tutorial3scope1.model.User;

import javax.inject.Inject;

public class FourthActivity extends AppCompatActivity {

    private UserComponent mUserComponent;

    // This User is created each time device is rotated
    // UserComponent is components are self-contained implementations,
    // exiting a scope is as simple as dropping all references to the component instance

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ((MyApplication) getApplication()).getUserComponent().inject(this);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Fourth User: " + user.hashCode());



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "FourthActivity onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
