package com.example.android.architecture.blueprints.todoapp.di;

import com.example.android.architecture.blueprints.todoapp.statistics.StatisticsActivity;
import com.example.android.architecture.blueprints.todoapp.statistics.StatisticsModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBindingModule_StatisticsActivity.StatisticsActivitySubcomponent.class
)
public abstract class ActivityBindingModule_StatisticsActivity {
  private ActivityBindingModule_StatisticsActivity() {}

  @Binds
  @IntoMap
  @ClassKey(StatisticsActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      StatisticsActivitySubcomponent.Factory builder);

  @Subcomponent(modules = StatisticsModule.class)
  @ActivityScoped
  public interface StatisticsActivitySubcomponent extends AndroidInjector<StatisticsActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<StatisticsActivity> {}
  }
}
