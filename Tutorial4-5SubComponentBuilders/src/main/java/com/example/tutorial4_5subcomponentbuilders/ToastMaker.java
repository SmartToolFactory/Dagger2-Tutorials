package com.example.tutorial4_5subcomponentbuilders;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class ToastMaker {

    private Context context;

    public ToastMaker(Context context) {
        this.context = context;
    }

    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


}
