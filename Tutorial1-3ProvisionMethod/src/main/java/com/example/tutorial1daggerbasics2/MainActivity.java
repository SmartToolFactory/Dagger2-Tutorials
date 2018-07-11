package com.example.tutorial1daggerbasics2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tutorial1daggerbasics2.di.DaggerVehicleComponent;
import com.example.tutorial1daggerbasics2.di.VehicleComponent;
import com.example.tutorial1daggerbasics2.di.VehicleModule;
import com.example.tutorial1daggerbasics2.model.Vehicle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


   private Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();

        vehicle = component.provideVehicle();

        Toast.makeText(this, String.valueOf(vehicle.getSpeed()), Toast.LENGTH_SHORT).show();
    }
}
