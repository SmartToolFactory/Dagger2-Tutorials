package com.smarttoolfactory.tutorial6_3subcomponentfactory

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.smarttoolfactory.tutorial6_3subcomponentfactory.di.DummyDependencySubComponent
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.DummyDependency
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.SensorController
import com.smarttoolfactory.tutorial6_3subcomponentfactory.model.SingletonObject
import javax.inject.Inject

/**
 * 🔥@ActivityScope on [ActivityScopedFragment] does not mean their objects live through
 * Activity lifecycle. Whenever [ActivityScopedFragment] fragment is replaced
 * new dependencies are re-created, because [DummyDependencySubComponent] is created inside
 * this fragment.
 */
class ActivityScopedFragment : Fragment() {

    // Injected from ApplicationModule
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // Injected from DummyDependencyModule @ActivityScope
    @Inject
    lateinit var dummyDependency: DummyDependency

    // Injected via Constructor Injection NOT Singleton
    @Inject
    lateinit var sensorController: SensorController

    // 🔥 Injected via Constructor Injection with @Singleton scope
    @Inject
    lateinit var singletonObject: SingletonObject


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvInfo).text =
                "Frag: $this\n" +
                        "ApplicationModule sharedPreferences: ${sharedPreferences.hashCode()}\n" +
                        "@ActivityScope DummyDependency: ${dummyDependency.hashCode()}\n" +
                        "Constructor Un-scoped sensorController: ${sensorController.hashCode()}\n" +
                        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"

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