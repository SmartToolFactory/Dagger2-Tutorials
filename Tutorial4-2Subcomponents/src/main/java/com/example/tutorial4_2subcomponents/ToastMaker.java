package com.example.tutorial4_2subcomponents;

import android.widget.Toast;

public class ToastMaker {

    private MainActivity mainActivity;

    public ToastMaker(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void showToast(String message) {
        Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show();
    }


}
