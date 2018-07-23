package com.example.tutorial5_1dagger_android_contributesandroidinjector;

import android.content.Context;

public class DummyDependency {

    private Context context;

    public DummyDependency(Context context) {
        this.context = context;
        System.out.println("DummyDependency Context: " + context);
    }

    public String getApplicationName() {
        return context.getString(R.string.app_name);
    }

}
