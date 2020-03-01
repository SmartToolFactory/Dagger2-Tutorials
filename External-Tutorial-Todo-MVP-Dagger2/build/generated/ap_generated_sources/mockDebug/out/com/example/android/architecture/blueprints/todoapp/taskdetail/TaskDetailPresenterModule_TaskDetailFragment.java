package com.example.android.architecture.blueprints.todoapp.taskdetail;

import com.example.android.architecture.blueprints.todoapp.di.FragmentScoped;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = TaskDetailPresenterModule_TaskDetailFragment.TaskDetailFragmentSubcomponent.class
)
public abstract class TaskDetailPresenterModule_TaskDetailFragment {
  private TaskDetailPresenterModule_TaskDetailFragment() {}

  @Binds
  @IntoMap
  @ClassKey(TaskDetailFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TaskDetailFragmentSubcomponent.Factory builder);

  @Subcomponent
  @FragmentScoped
  public interface TaskDetailFragmentSubcomponent extends AndroidInjector<TaskDetailFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<TaskDetailFragment> {}
  }
}
