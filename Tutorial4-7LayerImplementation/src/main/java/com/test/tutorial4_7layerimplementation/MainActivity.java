package com.test.tutorial4_7layerimplementation;

import android.os.Bundle;

import com.test.tutorial4_7layerlibrary.BaseActivity;
import com.test.tutorial4_7layerlibrary.model.User;

import javax.inject.Inject;

/**
 * If AppComponent exists in library layer, this class CANNOT inject any objects but CAN use the ones injected in {@link BaseActivity}
 * {@link com.test.tutorial4_7layerlibrary.model.ToastMaker} and {@link com.test.tutorial4_7layerlibrary.model.User} is injected to
 * {@link BaseActivity}
 */
public class MainActivity extends BaseActivity {

    // TODO CANNOT inject here, why?
    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ToastMaker is injected in library
        toastMaker.showToast("MainActivity Toast");

        user.setName("New User");
        System.out.println("MainActivity user: " + user.getName() + ", email: " + user.getEmail());

    }
}
