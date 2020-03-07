package com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.main

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.MySharedPreferences
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.model.ToastMaker
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FirstFragment : DaggerFragment() {

    // Injected from AppModule with @Singleton
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /**
     * Injected from [FirstFragmentModule] with @FragmentScope which
     * is created each time an instance of this fragment is created.
     */
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    /**
     * 🔥🔥🔥 Injected from [MainActivityModule] with @ActivityScope
     * which is the same object with MainActivity
     */
    @Inject
   lateinit var toastMaker: ToastMaker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvInfo).text =
                "Frag: $this\n" +
                        "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "MyFragmentModule @FragmentScope mySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "MainActivityModule @ActivityScope toastMaker: ${toastMaker.hashCode()}"
    }
}