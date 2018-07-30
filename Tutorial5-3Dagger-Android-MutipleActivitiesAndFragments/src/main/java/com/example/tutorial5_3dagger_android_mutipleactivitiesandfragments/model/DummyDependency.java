package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model;

import android.content.Context;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R;


public class DummyDependency {

    private Context context;

    public DummyDependency(Context context) {
        this.context = context;
    }

    public String getApplicationName() {
        return context.getString(R.string.app_name);
    }

}
