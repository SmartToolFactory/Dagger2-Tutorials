package com.example.android.architecture.blueprints.todoapp.di;

import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityBindingModule_TasksActivity.TasksActivitySubcomponent.class)
public abstract class ActivityBindingModule_TasksActivity {
  private ActivityBindingModule_TasksActivity() {}

  @Binds
  @IntoMap
  @ClassKey(TasksActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TasksActivitySubcomponent.Factory builder);

  @Subcomponent(modules = TasksModule.class)
  @ActivityScoped
  public interface TasksActivitySubcomponent extends AndroidInjector<TasksActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<TasksActivity> {}
  }
}
