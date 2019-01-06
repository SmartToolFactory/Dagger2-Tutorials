package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.ApplicationComponent;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.ToastAndPreferencesSubComponent;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.ToastMaker;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    // Injected from ApplicationModule
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from ToastMakerModule
    @Inject
    ToastMaker toastMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationComponent applicationComponent = ((MyApplication) getApplication()).getApplicationComponent();

        ToastAndPreferencesSubComponent toastMakerSubComponent = applicationComponent
                .toastMakerBuilder()
                .context(this)
                .build();

        toastMakerSubComponent.inject(this);

        toastMaker.showToast("SharedPreferences: " + sharedPreferences);

        TextView textView = findViewById(R.id.text_view);

        textView.setText("ToastMaker: " + toastMaker + "\n sharedPreferences: " + sharedPreferences);

    }
}
