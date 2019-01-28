package com.test.tutorial4_7layerlibrary.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.test.tutorial4_7layerlibrary.model.User;

public class BaseViewModel extends ViewModel {

    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();

    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public BaseViewModel() {

    }
}
