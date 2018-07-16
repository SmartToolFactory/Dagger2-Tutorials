package zorail.rohan.com.subcomponent.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zorail on 11-May-17.
 */
@Module
public class AppModule {

    Application mApplication;
    public AppModule(Application mApplication)
    {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return mApplication;}
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application)
    {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }


}
