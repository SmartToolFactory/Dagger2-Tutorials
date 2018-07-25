package com.gabrielsamojlo.dagger_212;

import android.content.Context;

public class DummyDependency {

    private Context context;

    public DummyDependency(Context context) {
        this.context = context;
    }

    public String getApplicationName() {
        return context.getString(R.string.app_name);
    }

}
