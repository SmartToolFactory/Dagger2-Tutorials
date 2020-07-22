package com.smarttoolfactory.feature_hilt_photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class PhotoFragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photos2, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initMainActivityDependentInjection()
        super.onCreate(savedInstanceState)
    }


    private fun initMainActivityDependentInjection() {

//        val mainActivity = requireActivity() as MainActivity
//        DaggerPhotoComponent.factory()
//                .create(mainActivityComponent = mainActivity.mainActivityComponent,
//                        photoModule = PhotoModule(),
//                        application = mainActivity.application)
//                .inject(this)

    }

}