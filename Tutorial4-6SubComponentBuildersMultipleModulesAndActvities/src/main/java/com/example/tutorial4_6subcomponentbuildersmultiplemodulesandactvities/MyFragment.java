package com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.ApplicationComponent;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.di.ToastMakerSubComponent;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.MySharedPreferences;
import com.example.tutorial4_6subcomponentbuildersmultiplemodulesandactvities.model.ToastMaker;

import javax.inject.Inject;

public class MyFragment extends Fragment {

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
        ApplicationComponent applicationComponent = ((MyApplication) getActivity().getApplication()).getApplicationComponent();

        ToastMakerSubComponent toastMakerSubComponent = applicationComponent.toastMakerBuilder().context(getActivity()).build();
        toastMakerSubComponent.inject(this);


        toastMaker.showToast("Toast from Fragment " + sharedPreferences);

        mySharedPreferences.putData("data", 12);

        toastMaker.showToast("Data from Fragment: " + mySharedPreferences.getData("data"));


    }
}
