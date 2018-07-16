package zorail.rohan.com.subcomponent.module;


import android.content.SharedPreferences;



import dagger.Module;
import dagger.Provides;
import zorail.rohan.com.subcomponent.scope.UserScope;

/**
 * Created by zorail on 11-May-17.
 */
@Module
public class NetModule {

    @Provides
    @UserScope
    SharedPreferences.Editor provideSharedPreferencesEditor(SharedPreferences preferences)
    {
        return preferences.edit();
    }
}
