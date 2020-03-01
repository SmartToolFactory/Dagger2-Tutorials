package com.example.tutorial5_2dagger_android_subcomponents3.di;

import com.example.tutorial5_2dagger_android_subcomponents3.SecondActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityContributorModule_ContributeSecondActivity.SecondActivitySubcomponent.class
)
public abstract class ActivityContributorModule_ContributeSecondActivity {
  private ActivityContributorModule_ContributeSecondActivity() {}

  @Binds
  @IntoMap
  @ClassKey(SecondActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SecondActivitySubcomponent.Factory builder);

  @Subcomponent(modules = SecondActivityModule.class)
  @ActivityScope
  public interface SecondActivitySubcomponent extends AndroidInjector<SecondActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SecondActivity> {}
  }
}
