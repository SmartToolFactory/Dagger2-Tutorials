package com.example.tutorial3scope1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial3scope1.di.DaggerUserComponent;
import com.example.tutorial3scope1.di.UserComponent;
import com.example.tutorial3scope1.model.User;

import javax.inject.Inject;

public class Activity3 extends AppCompatActivity {

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_123);

        // Get Application Component
        // ((MyApplication) getApplication()).getUserComponent().inject(this);

        // Get Class Component
        UserComponent daggerUserComponent = DaggerUserComponent.create();
        // TODO NEED to ADD void inject(Activity3 thirdActivity); UserComponent
        daggerUserComponent.inject(this);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this, Activity4.class);
                startActivity(intent);
            }
        });


        TextView textView = findViewById(R.id.textView);
        textView.setText("Third User: " + user.hashCode());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity3 onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
