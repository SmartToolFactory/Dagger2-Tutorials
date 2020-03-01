package com.example.android.architecture.blueprints.todoapp.tasks;

import com.example.android.architecture.blueprints.todoapp.di.FragmentScoped;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = TasksModule_TasksFragment.TasksFragmentSubcomponent.class)
public abstract class TasksModule_TasksFragment {
  private TasksModule_TasksFragment() {}

  @Binds
  @IntoMap
  @ClassKey(TasksFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TasksFragmentSubcomponent.Factory builder);

  @Subcomponent
  @FragmentScoped
  public interface TasksFragmentSubcomponent extends AndroidInjector<TasksFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<TasksFragment> {}
  }
}
