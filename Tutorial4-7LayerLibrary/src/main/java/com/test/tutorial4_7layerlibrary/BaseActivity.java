package com.test.tutorial4_7layerlibrary;

import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.tutorial4_7layerlibrary.model.ToastMaker;
import com.test.tutorial4_7layerlibrary.model.User;
import com.test.tutorial4_7layerlibrary.viewmodel.BaseViewModel;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

    public BaseViewModel viewModel;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    protected ToastMaker toastMaker;

    @Inject
    protected User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((BaseApplication) getApplication()).getBaseAppComponent().inject(this);

        System.out.println("BaseActivity sharedPreferences: " + sharedPreferences);
        System.out.println("BaseActivity user: " + user.getName() + ", email: " + user.getEmail());

        toastMaker.showToast("BaseActivity Toast");

        viewModel = ViewModelProviders.of(this).get(BaseViewModel.class);
    }
}
