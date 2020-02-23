package com.example.tutorial4_4componentbuildersmultiplemodules;

import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial4_4componentbuildersmultiplemodules.model.SensorController;
import com.example.tutorial4_4componentbuildersmultiplemodules.model.ToastMaker;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements SensorController.OnSensorEventChangeListener {

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    ToastMaker toastMaker;

    @Inject
    SensorController sensorController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getAppComponent().inject(this);
/*
        ((MyApplication) getApplication()).getAppComponentWithBind().inject(this);
*/
        toastMaker.showToast("sharedPreferences " + sharedPreferences);
        sensorController.setSensorEventChangeListener(this);

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
        TextView textView = findViewById(R.id.result);
        textView.setText("Azimuth: " + azimuth + ", float: " + pitch + ", roll: " + roll);
    }
}
