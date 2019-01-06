package com.example.tutorial1basics3;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tutorial1basics3.sensors.SensorController;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements SensorController.OnSensorEventChangeListener {

    // Inject field Application from Module with provideMyApplication
    @Inject
    MyApplication myApplication;

    // Inject field SensorController from Module with provideSensorController
    // This object is Singleton and same instance is injected on device rotation
    @Inject
    SensorController mSensorController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getAppContextComponent().inject(this);
        mSensorController.setSensorEventChangeListener(this);

        System.out.println("SensorController: " + mSensorController);

        Toast.makeText(myApplication, "myApplication: " + myApplication, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorController.onResume(SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorController.onPause();
    }

    @Override
    public void getOrientationValues(float azimuth, float pitch, float roll) {
        TextView textView = findViewById(R.id.result);
        textView.setText("Azimuth: " + azimuth + ", float: " + pitch + ", roll: " + roll);
    }
}
