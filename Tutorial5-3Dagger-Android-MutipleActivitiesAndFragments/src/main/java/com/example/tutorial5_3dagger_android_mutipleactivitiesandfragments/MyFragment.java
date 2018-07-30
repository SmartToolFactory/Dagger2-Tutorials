package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.MySharedPreferences;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.model.ToastMaker;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
public class MyFragment extends DaggerFragment {

    // Injected from ApplicationModule
    @Inject
    SharedPreferences sharedPreferences;

    // Injected from MySharedPreferencesModule
    @Inject
    MySharedPreferences mySharedPreferences;

    // Injected from ToastMakerModule
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


        toastMaker.showToast("Toast from Fragment " + sharedPreferences);

        mySharedPreferences.putData("data", 12);

        toastMaker.showToast("Data from Fragment: " + mySharedPreferences.getData("data"));


    }
}
