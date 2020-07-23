package com.smarttoolfactory.tutorial10_1dfm_daggerhilt

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial10_1core.di.CoreModule
import com.smarttoolfactory.tutorial10_1core.model.CoreActivityDependency
import com.smarttoolfactory.tutorial10_1core.model.CoreDependency
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.di.MainActivityModule
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.MainActivityObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.SensorController
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.SingletonObject
import com.smarttoolfactory.tutorial10_1dfm_daggerhilt.model.ToastMaker
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/*
    Project dependency Structure

 feature_hilt_camera    feature_hilt_photos  (Dynamic Feature Modules)
        |         |          |
        |         ----App----
        |              |
        core(android-library)
 */
/**
 * Tutorial to inject dependencies to dynamic feature modules either
 * ApplicationComponent and ActivityComponent. This tutorial has the same architecture with
 * Tutorial 9-2 but uses Dagger Hilt instead of regular dagger
 *
 * * Create Module in core module(CoreModule)
 * * Create an interface with @EntryPoint with provision methods(CoreComponent, name is not convenient but it's named with same name Tutorial 9-2 has)
 * * In Camera DFM use dependency in CameraComponent and use factory or builder pattern to build it
 * * In fragment or Activity use EntryPoints.fromX(Activity, or Fragment) to get CoreComponent(this is dependencies with @EntryPoint)
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /**
     * Injected from [CoreModule] with @Singleton scope
     */
    @Inject
    lateinit var coreDependency: CoreDependency

    /**
     * Injected from [CoreModule] with no scope
     */
    @Inject
    lateinit var coreActivityDependency: CoreActivityDependency

    /**
     * Injected from [MainActivityModule] with no scope
     */
    @Inject
    lateinit var toastMaker: ToastMaker

    /**
     *
     * Injected from [MainActivityModule] with @ActivityScoped
     * * To inject this there should be @Binds that gets Context from an Application
     */
    @Inject
    lateinit var mainActivityObject: MainActivityObject

    /**
     * Injected via constructor injection with no scope
     */
    @Inject
    lateinit var sensorController: SensorController

    /**
     * Injected via constructor injection with @Singleton scope
     *
     * ### Unlike Tutorial 9-2 This can be injected because MainActivity's component does not
     * depend on any component with another scope
     */
    @Inject
    lateinit var singletonObject: SingletonObject

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvInfo).text =
                "CoreModule @Singleton coreDependency: ${coreDependency.hashCode()}\n" +
                        "CoreModule no scope coreActivityDependency: ${coreActivityDependency.hashCode()}\n" +
                        "MainActivityModule @ActivityScoped mainActivityObject: ${mainActivityObject.hashCode()}\n" +
                        "MainActivityModule no scope toastMaker: ${toastMaker.hashCode()}\n" +
                        "Constructor no scope sensorController: ${sensorController.hashCode()}\n"
        "Constructor @Singleton singletonObject: ${singletonObject.hashCode()}"


    }
}