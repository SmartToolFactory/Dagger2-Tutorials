package com.test.tutorial4_8layerimplementation2;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.test.tutorial4_8layerimplementation2.di.model.ToastDisplayer;
import com.test.tutorial4_8layerlibrary.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getName();
    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    ToastDisplayer toastDisplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastDisplayer.showToast("MainActivity sharedPreferences: " + sharedPreferences);

        //    toastDisplayer.showToast("MainActivity test: " + baseApplication.testResult());

        // toastDisplayer.showToast("User: "+ user);
    }


}
