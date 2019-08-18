package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.SensorController;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.ToastMaker;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.second.SecondActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


/*
    MainActivity contains MyFragment and passes MainActivity context to fragment with

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentContributorModule.class})
    abstract MainActivity contributeMainActivity();
 */

public class MainActivity extends DaggerAppCompatActivity implements SensorController.OnSensorEventChangeListener {


    // Injected from AppModule with @Singleton
    @Inject
    SharedPreferences sharedPreferences;

    /**
     * Injected from {@link MainActivityModule} with @ActivityScope
     * which is the same object with MyFragment.
     */
    @Inject
    ToastMaker toastMaker;

    // Constructor Injection
    @Inject
    SensorController sensorController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("🔥 MainActivity toastMaker: " + toastMaker);
        System.out.println("🔥 MainActivity sharedPreferences: " + sharedPreferences);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,new MyFragment()).commit();

        toastMaker.showToast("MainActivity sharedPreferences " + sharedPreferences);
        sensorController.setSensorEventChangeListener(this);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

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

    @Override
    public void getOrientationValues(float azimuth, float pitch, float roll) {
        TextView textView = findViewById(R.id.text_view);
        textView.setText("Azimuth: " + azimuth + ", float: " + pitch + ", roll: " + roll);
    }
}