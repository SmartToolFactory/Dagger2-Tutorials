package com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.model

import android.content.Context
import com.smarttoolfactory.tutorial6_4_sucomponentfactory_multipleactivitiesandfragments.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Constructor injected component should have the same scope with the component that is injects to same object
 * or no scope at all
 */

@ActivityScope
class SensorController @Inject constructor(context: Context)