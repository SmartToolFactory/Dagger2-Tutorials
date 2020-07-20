package com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.main

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.R
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model.FragmentObject
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model.MySharedPreferences
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model.SensorController
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model.ToastMaker
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment() {

    // Injected from AppModule with @Singleton
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /**
     * Injected from [SecondFragmentModule] with @FragmentScope which
     * is created each time an instance of this fragment is created.
     */
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    /**
     * 🔥🔥🔥 Injected from [MainActivityModule] with @ActivityScope
     * which is the same object with [MainActivity] and [FirstFragment]
     */
    @Inject
    lateinit var toastMaker: ToastMaker

    /**
     * Injected via constructor injection with @FragmentScoped
     */
    @Inject
    lateinit var fragmentObject: FragmentObject

    /**
     * 🔥🔥🔥 Injected via constructor injection with @ActivityScoped
     * and same object with [MainActivity]
     */
    @Inject
    lateinit var sensorController: SensorController


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvTitle).text =
                "Frag: ${this.javaClass.simpleName} #${this.hashCode()}\n"

        view.findViewById<TextView>(R.id.tvInfo).text =
                        "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "SecondFragmentModule @FragmentScoped mySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "🔥 MainActivityModule @ActivityScope toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor @FragmentScoped fragObject: ${fragmentObject.hashCode()}\n" +
                        "Constructor @ActivityScoped sensorController: ${sensorController.hashCode()}"
    }
}