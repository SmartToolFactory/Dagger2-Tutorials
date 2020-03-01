package com.smarttoolfactory.tutorial6_3subcomponentfactory

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.DummyDependency
import javax.inject.Inject

class ActivityScopedFragment : Fragment() {

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from DummyDependencyModule
    @Inject
    lateinit var dummyDependency: DummyDependency


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvInfo).text =
                "Frag: $this\n" +
                        "DummyDependenyc: ${dummyDependency.hashCode()}\n" +
                        "sharedPreferences: ${sharedPreferences.hashCode()}"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initInjection()


    }

    private fun initInjection() {

        val appComponent = (activity!!.application as MyApplication).appComponent

        // 🔥SubComponent Builder
//        val dummyDependencyComponent = appComponent
//                .dummyDependencyBuilder()
//                .context(this)
//                .build()

        // 🔥 SubComponent Factory
        val dummyDependencySubComponent = appComponent
                .dummyDependencyComponentFactory
                .create(activity!!)

        dummyDependencySubComponent.inject(this)
    }
}