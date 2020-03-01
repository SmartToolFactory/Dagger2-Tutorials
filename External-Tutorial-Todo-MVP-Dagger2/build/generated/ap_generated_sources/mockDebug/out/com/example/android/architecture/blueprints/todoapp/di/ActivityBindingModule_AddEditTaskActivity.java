package com.example.android.architecture.blueprints.todoapp.di;

import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskActivity;
import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBindingModule_AddEditTaskActivity.AddEditTaskActivitySubcomponent.class
)
public abstract class ActivityBindingModule_AddEditTaskActivity {
  private ActivityBindingModule_AddEditTaskActivity() {}

  @Binds
  @IntoMap
  @ClassKey(AddEditTaskActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddEditTaskActivitySubcomponent.Factory builder);

  @Subcomponent(modules = AddEditTaskModule.class)
  @ActivityScoped
  public interface AddEditTaskActivitySubcomponent extends AndroidInjector<AddEditTaskActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AddEditTaskActivity> {}
  }
}
