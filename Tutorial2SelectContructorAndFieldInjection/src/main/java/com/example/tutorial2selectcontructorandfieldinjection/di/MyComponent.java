package com.example.tutorial2selectcontructorandfieldinjection.di;


import com.example.tutorial2selectcontructorandfieldinjection.MainActivity;
import javax.inject.Singleton;
import dagger.Component;

@Component(modules = SharedPreferencesModule.class)
@Singleton
public interface MyComponent {
    void inject(MainActivity mainActivity);
}