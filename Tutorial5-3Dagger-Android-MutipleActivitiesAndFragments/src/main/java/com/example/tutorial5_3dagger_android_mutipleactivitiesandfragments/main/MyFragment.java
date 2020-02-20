package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.MySharedPreferences;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.ToastMaker;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class MyFragment extends DaggerFragment {

    // Injected from AppModule with @Singleton
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from MySharedPreferencesModule
    @Inject
    MySharedPreferences mySharedPreferences;

    /**
     * Injected from {@link MainActivityModule} with @ActivityScope
     * which is the same object with MainActivity
     */
    @Inject
    ToastMaker toastMaker;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toastMaker.showToast("MyFragment Toast from Fragment " + sharedPreferences);

        System.out.println("🥶 MyFragment mySharedPreferences: " + mySharedPreferences);
        System.out.println("🥶 MyFragment sharedPreferences: " + sharedPreferences);
        System.out.println("🥶 MyFragment toastMaker: " + toastMaker);

        mySharedPreferences.putData("data", 12);

        toastMaker.showToast("MyFragment Data from Fragment: " + mySharedPreferences.getData("data"));


    }
}
