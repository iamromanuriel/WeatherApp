package com.romanuriel.weatherapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragmentBinding<B: ViewBinding>: Fragment(), IBaseView{
    lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,layout(),container,false)
        return binding.root
    }

    abstract fun layout(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent(view, savedInstanceState)
    }

    abstract fun initComponent(view: View, savedInstanceState: Bundle?)

    override fun showComponentProgressBar(value: Boolean) {
        (activity as MainActivity).showProgressBar(value)
    }

    override fun showMessageWithToast(message: Any) {
        val msg = when(message){
            is String -> message
            is Int -> message.toString()
            else -> {"Tipo no valido"}
        }
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun showMessageWithSnackbar(message: Any) {
        val msg = when(message){
            is String -> message
            is Int -> message.toString()

            else -> {"Tipo no valido"}
        }
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
    }

    override fun initDebug(value: Any) {
        val msg = value.toString()
        Log.d("TAG",msg)
    }


}