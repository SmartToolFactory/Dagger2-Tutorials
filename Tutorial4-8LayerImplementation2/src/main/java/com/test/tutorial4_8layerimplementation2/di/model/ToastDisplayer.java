package com.test.tutorial4_8layerimplementation2.di.model;

import android.content.Context;
import android.widget.Toast;

public class ToastDisplayer {

    private Context context;

    public ToastDisplayer(Context context) {
        this.context = context;
    }

    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
