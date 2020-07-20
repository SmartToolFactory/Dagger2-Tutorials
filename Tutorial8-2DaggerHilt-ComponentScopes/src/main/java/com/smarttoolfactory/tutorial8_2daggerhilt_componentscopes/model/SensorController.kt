package com.smarttoolfactory.tutorial8_2daggerhilt_componentscopes.model

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class SensorController @Inject constructor(@ApplicationContext context: Context)