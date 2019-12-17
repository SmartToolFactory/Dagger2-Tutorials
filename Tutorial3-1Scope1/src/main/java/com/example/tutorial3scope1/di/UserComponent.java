package com.example.tutorial3scope1.di;


import com.example.tutorial3scope1.Activity1;
import com.example.tutorial3scope1.Activity4;
import com.example.tutorial3scope1.Activity2;
import com.example.tutorial3scope1.Activity3;

import dagger.Component;

@ActivityScope
@Component(modules = {UserModule.class})
public interface UserComponent {
    void inject(Activity1 activity1);

    void inject(Activity2 activity2);

    void inject(Activity3 activity3);

    void inject(Activity4 activity4);
}
