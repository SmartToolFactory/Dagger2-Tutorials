package com.test.tutorial4_8layerlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.test.tutorial4_8layerlibrary.model.DummyModel;
import com.test.tutorial4_8layerlibrary.model.User;
import com.test.tutorial4_8layerlibrary.viewmodel.BaseViewModel;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    public BaseViewModel viewModel;

/*    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    protected ToastMaker toastMaker;

    @Inject
    protected User user;*/

    @Inject
    protected User user;

/*    @Inject
    protected ToastMaker toastMaker;*/

    @Inject
    protected DummyModel dummyModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        System.out.println("BaseActivity sharedPreferences: " + sharedPreferences);
        System.out.println("BaseActivity user: " + user.getName() + ", email: " + user.getEmail());

//        toastMaker.showToast("BaseActivity Toast");

        //    System.out.println("BaseActivity result: " + getBaseApplication().testResult());

    }


}
