package com.example.tutorial4_5subcomponentbuilders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tutorial4_5subcomponentbuilders.di.ApplicationComponent;
import com.example.tutorial4_5subcomponentbuilders.di.ToastMakerSubComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    // Injected from ApplicationModule
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from ToastMaker SubComponent Module
    @Inject
    ToastMaker toastMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationComponent applicationComponent = ((MyApplication) getApplication()).getApplicationComponent();

        ToastMakerSubComponent toastMakerSubComponent = applicationComponent
                .toastMakerBuilder()
                .context(this)
                .build();

        toastMakerSubComponent.inject(this);

        toastMaker.showToast("sharedPreferences " + sharedPreferences);

        Integer.toString(5);


    }
}
