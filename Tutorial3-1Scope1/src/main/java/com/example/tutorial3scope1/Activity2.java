package com.example.tutorial3scope1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial3scope1.model.User;

import javax.inject.Inject;

public class Activity2 extends AppCompatActivity {

    @Inject
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_123);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });


        ((MyApplication) getApplication()).getUserComponent().inject(this);


        TextView textView = findViewById(R.id.textView);
        textView.setText("Second User: " + user.hashCode());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity2 onDestroy()", Toast.LENGTH_SHORT).show();
    }

}
