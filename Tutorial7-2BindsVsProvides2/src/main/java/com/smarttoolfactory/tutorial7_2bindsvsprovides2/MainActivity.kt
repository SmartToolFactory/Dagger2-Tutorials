package com.smarttoolfactory.tutorial7_2bindsvsprovides2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.di.logger.LoggerModule
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.model.Logger
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.model.SensorController
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.model.Snacker
import com.smarttoolfactory.tutorial7_2bindsvsprovides2.model.Toaster
import javax.inject.Inject
import javax.inject.Named

/**
 * Companion object with @Module annotation inside a module
 * generates 2 classes for each injected object.
 *
 * For instance, for [Logger] in [LoggerModule]
 * generates:
 *
 * * 1- LoggerModuleWithProvides_ProvideLoggerFactory
 * * 2- LoggerModuleWithProvides_Companion_ProvideLoggerFactory
 *
 * 🔥🔥🔥 with 3 provides method inside 6 classes are generated instead of 3
 *
 */
class MainActivity : AppCompatActivity() {


    // ***** LoggerWithProvidesModule *****

    @Inject
    @Named("LoggerModuleBindsLogger")
    lateinit var loggerBindsInProviderModule: Logger

    /**
     * Injected from LoggerWithProvidesModule with @Provides
     */
    @Inject
    @Named("LoggerCompanionModuleProvidesLogger")
    lateinit var loggerProvided: Logger

    @Named("LoggerCompanionModuleProvidesSnacker")
    @Inject
    lateinit var snacker: Snacker

    @Inject
    lateinit var sensorController: SensorController


    // ***** ToasterModule and ToasterProviderModule *****

    /**
     * Injected from ToasterModule with @Binds
     */
    @Inject
    @Named("bindsToaster")
    lateinit var toasterBound: Toaster

    /**
     * Injected from ToasterProviderModule with @Provides
     */
    @Inject
    @Named("providesToaster")
    lateinit var toasterProvided: Toaster


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).appComponent.inject(this)

    }
}
