package zorail.rohan.com.subcomponent;

import android.app.Application;


import zorail.rohan.com.subcomponent.component.AppComponent;
import zorail.rohan.com.subcomponent.component.DaggerAppComponent;
import zorail.rohan.com.subcomponent.module.AppModule;

/**
 * Created by zorail on 11-May-17.
 */

public class MyApp extends Application {

    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }
    public AppComponent getComponent()
    {
        return component;
    }
}
