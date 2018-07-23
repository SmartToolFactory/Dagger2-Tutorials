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

public class ThirdActivity extends AppCompatActivity {

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Application Component
        // ((MyApplication) getApplication()).getUserComponent().inject(this);

        // Get Class Component
        UserComponent daggerUserComponent = DaggerUserComponent.create();
        // TODO NEED to ADD void inject(ThirdActivity thirdActivity); UserComponent
        daggerUserComponent.inject(this);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });


        TextView textView = findViewById(R.id.textView);
        textView.setText("Third User: " + user.hashCode());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "ThirdActivity onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
