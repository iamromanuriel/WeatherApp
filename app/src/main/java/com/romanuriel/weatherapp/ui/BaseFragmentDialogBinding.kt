package com.romanuriel.weatherapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentDialogBinding <B: ViewBinding>: DialogFragment() {
    lateinit var binding : B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,layout(),container,false)
        return binding.root
    }

    abstract fun layout(): Int
}