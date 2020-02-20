package com.example.tutorial4_1dependentcomponent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial4_1dependentcomponent.di.DaggerMotorComponent;
import com.example.tutorial4_1dependentcomponent.di.DaggerVehicleComponent;
import com.example.tutorial4_1dependentcomponent.di.MotorComponent;
import com.example.tutorial4_1dependentcomponent.di.MotorModule;
import com.example.tutorial4_1dependentcomponent.di.VehicleComponent;
import com.example.tutorial4_1dependentcomponent.di.VehicleModule;
import com.example.tutorial4_1dependentcomponent.model.Vehicle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Vehicle mVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MotorComponent motorComponent = DaggerMotorComponent
                .builder()
                .motorModule(new MotorModule())
                .build();


        VehicleComponent vehicleComponent = DaggerVehicleComponent
                .builder()
                .motorComponent(motorComponent)
                .vehicleModule(new VehicleModule())
                .build();

        vehicleComponent.inject(this);

        TextView textView = findViewById(R.id.text_view);
        mVehicle.increaseSpeed(30);
        textView.setText("Vecihle speed:" + mVehicle.getSpeed());

    }
}
