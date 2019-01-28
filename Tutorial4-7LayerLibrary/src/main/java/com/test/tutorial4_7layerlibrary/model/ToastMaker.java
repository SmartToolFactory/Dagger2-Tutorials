package com.test.tutorial4_7layerlibrary.model;

import android.app.Application;
import android.widget.Toast;

public class ToastMaker {

    private Application application;

    public ToastMaker(Application application) {
        this.application = application;
    }

    public void showToast(String message) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT).show();
    }


}
