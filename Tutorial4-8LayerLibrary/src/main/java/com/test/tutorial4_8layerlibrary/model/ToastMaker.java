package com.test.tutorial4_8layerlibrary.model;

import android.content.Context;
import android.widget.Toast;

public class ToastMaker {

    private Context context;

    public ToastMaker(Context context) {
        this.context = this.context;
    }

    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


}
