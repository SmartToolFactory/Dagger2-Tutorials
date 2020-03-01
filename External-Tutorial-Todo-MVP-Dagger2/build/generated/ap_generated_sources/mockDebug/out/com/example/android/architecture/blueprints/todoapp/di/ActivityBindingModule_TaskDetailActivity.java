package com.example.android.architecture.blueprints.todoapp.di;

import com.example.android.architecture.blueprints.todoapp.taskdetail.TaskDetailActivity;
import com.example.android.architecture.blueprints.todoapp.taskdetail.TaskDetailPresenterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBindingModule_TaskDetailActivity.TaskDetailActivitySubcomponent.class
)
public abstract class ActivityBindingModule_TaskDetailActivity {
  private ActivityBindingModule_TaskDetailActivity() {}

  @Binds
  @IntoMap
  @ClassKey(TaskDetailActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TaskDetailActivitySubcomponent.Factory builder);

  @Subcomponent(modules = TaskDetailPresenterModule.class)
  @ActivityScoped
  public interface TaskDetailActivitySubcomponent extends AndroidInjector<TaskDetailActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<TaskDetailActivity> {}
  }
}
