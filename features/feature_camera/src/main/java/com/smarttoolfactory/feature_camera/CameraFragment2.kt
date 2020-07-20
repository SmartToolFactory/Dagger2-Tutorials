package com.smarttoolfactory.feature_camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smarttoolfactory.feature_camera.di.CameraModule
import com.smarttoolfactory.feature_camera.di.DaggerCameraComponent
import com.smarttoolfactory.tutorial9_2dynamicfeatureimplementation2.coreComponent

class CameraFragment2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_camera2, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        initCoreDependentInjection()
        super.onCreate(savedInstanceState)
    }

    private fun initCoreDependentInjection() {

        DaggerCameraComponent.factory()
                .create(coreComponent = requireActivity().coreComponent(),
                        cameraModule = CameraModule(),
                        application = requireActivity().application)
                .inject(this)
    }

}