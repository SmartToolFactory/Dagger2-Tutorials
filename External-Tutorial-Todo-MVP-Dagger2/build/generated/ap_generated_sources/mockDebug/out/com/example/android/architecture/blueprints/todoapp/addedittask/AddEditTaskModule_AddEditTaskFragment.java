package com.example.android.architecture.blueprints.todoapp.addedittask;

import com.example.android.architecture.blueprints.todoapp.di.FragmentScoped;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = AddEditTaskModule_AddEditTaskFragment.AddEditTaskFragmentSubcomponent.class)
public abstract class AddEditTaskModule_AddEditTaskFragment {
  private AddEditTaskModule_AddEditTaskFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AddEditTaskFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddEditTaskFragmentSubcomponent.Factory builder);

  @Subcomponent
  @FragmentScoped
  public interface AddEditTaskFragmentSubcomponent extends AndroidInjector<AddEditTaskFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AddEditTaskFragment> {}
  }
}
