package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.ApplicationComponent;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.DummyDependencyComponent;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.DummyDependency;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.SensorController;

import javax.inject.Inject;

/*
 ONLY one component can inject to an Object
 */
public class MainActivity extends AppCompatActivity {

    // Injected from ApplicationModule
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from DummyDependencyModule
    @Inject
    DummyDependency dummyDependency;

    // Constructor Injection
    @Inject
    SensorController sensorController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationComponent applicationComponent = ((MyApplication) getApplication()).getApplicationComponent();


        // Dummy Dependency
        DummyDependencyComponent dummyDependencyComponent = applicationComponent
                .dummyDependencyBuilder()
                .context(this)
                .build();

        dummyDependencyComponent.inject(this);


        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        TextView textView = findViewById(R.id.text_view);
        textView.setText("Dummy: " + dummyDependency.getApplicationName());

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, new MyFragment()).commit();

        Toast.makeText(this, "MainActivity: " + sharedPreferences, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorController.onResume(SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorController.onPause();
    }
}
