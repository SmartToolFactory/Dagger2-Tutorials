package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model;

import android.content.Context;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.R;

public class DummyDependency {

    private Context context;

    public DummyDependency(Context context) {
        this.context = context;
    }

    public String getApplicationName() {
        return context.getString(R.string.app_name);
    }

}
