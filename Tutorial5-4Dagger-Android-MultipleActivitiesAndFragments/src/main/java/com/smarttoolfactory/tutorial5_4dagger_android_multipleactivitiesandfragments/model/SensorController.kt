package com.smarttoolfactory.tutorial5_4dagger_android_multipleactivitiesandfragments.model

import android.content.Context
import com.example.tutorial5_3dagger_android_multipleactivitiesandfragments.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Constructor injected component should have the same scope with the component that is injects to same object
 * or no scope at all
 */

@ActivityScope
class SensorController @Inject constructor(context: Context)