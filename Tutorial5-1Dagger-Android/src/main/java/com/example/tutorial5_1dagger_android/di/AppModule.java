package com.example.tutorial5_1dagger_android.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.tutorial5_1dagger_android.DummyDependency;
import com.example.tutorial5_1dagger_android.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;


@Module(subcomponents = MainActivitySubComponent.class)
public abstract class AppModule {

    /**
     * Generates an abstract class from a concrete class
     *
     * @param application
     * @return context of application
     */
    @Binds
    public abstract Context bindContext(Application application);

    @Provides
    static DummyDependency provideDummyDependency(Context context) {
        return new DummyDependency(context);
    }



    /*
     * @Binds : Returns concrete class from an abstract one such as
     *
     * @Binds
     * Context bindContext(MainActivity activity);
     * or
     * @Binds
     * DetailView provideDetailView(DetailActivity detailActivity);
     *
     */

    /*
     * @IntoMap:
     */

    /*
     * @ActivityKey:
     */

    /*
     * 🔥🔥 NOTE: This is same as adding void inject(MainActivity mainActivity) in a SubComponent as in
     *  non dagger-android, and can be removed using
     *  @ContributesAndroidInjector if SubComponent and it's Builder has NO methods
     */

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindInjectorFactory(MainActivitySubComponent.Builder builder);

}


