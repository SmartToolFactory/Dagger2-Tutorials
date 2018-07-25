package com.example.tutorial5_2dagger_android_subcomponents3;

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
