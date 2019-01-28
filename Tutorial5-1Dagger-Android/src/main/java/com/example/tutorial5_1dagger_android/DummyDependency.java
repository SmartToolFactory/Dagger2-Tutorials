package com.example.tutorial5_1dagger_android;

import android.content.Context;

/**
 * Context of this class comes from
 *  @Binds
    public abstract Context bindContext(Application application);
    which is in {@link com.example.tutorial5_1dagger_android.di.AppModule}
 */
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
