package com.example.tutorial5_2dagger_android_subcomponents3.di;

import com.example.tutorial5_2dagger_android_subcomponents3.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityContributorModule_ContributeMainActivity.MainActivitySubcomponent.class
)
public abstract class ActivityContributorModule_ContributeMainActivity {
  private ActivityContributorModule_ContributeMainActivity() {}

  @Binds
  @IntoMap
  @ClassKey(MainActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Factory builder);

  @Subcomponent(modules = MainActivityModule.class)
  @ActivityScope
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {}
  }
}
