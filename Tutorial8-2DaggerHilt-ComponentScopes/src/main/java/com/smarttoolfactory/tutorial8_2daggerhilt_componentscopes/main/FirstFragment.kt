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
import com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model.ToastMaker
import dagger.hilt.android.AndroidEntryPoint

import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {


    // Injected from AppModule with @Singleton
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /**
     * Injected from [FragmentModule] with @FragmentScoped which
     * is created each time an instance of this fragment is created.
     */
    @Inject
    lateinit var mySharedPreferences: MySharedPreferences

    /**
     * 🔥🔥🔥 Injected from [MainActivityModule] with @ActivityScope
     * which is the same object with [MainActivity] and [SecondFragment]
     */
    @Inject
    lateinit var toastMaker: ToastMaker

    /**
     * Injected via constructor injection with @FragmentScoped
     */
    @Inject
    lateinit var fragmentObject: FragmentObject


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvTitle).text =
                "Frag: ${this.javaClass.simpleName} #${this.hashCode()}\n"

        view.findViewById<TextView>(R.id.tvInfo).text =
                        "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "FragmentModule @FragmentScoped mySharedPreferences: ${mySharedPreferences.hashCode()}\n" +
                        "🔥 MainActivityModule @ActivityScoped toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor @FragmentScope fragObject: ${fragmentObject.hashCode()}"
    }
}