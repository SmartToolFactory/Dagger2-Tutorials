package com.example.android.architecture.blueprints.todoapp.statistics;

import com.example.android.architecture.blueprints.todoapp.di.FragmentScoped;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = StatisticsModule_StatisticsFragment.StatisticsFragmentSubcomponent.class)
public abstract class StatisticsModule_StatisticsFragment {
  private StatisticsModule_StatisticsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(StatisticsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      StatisticsFragmentSubcomponent.Factory builder);

  @Subcomponent
  @FragmentScoped
  public interface StatisticsFragmentSubcomponent extends AndroidInjector<StatisticsFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<StatisticsFragment> {}
  }
}
