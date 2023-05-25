package com.romanuriel.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import com.romanuriel.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
    }

    fun showProgressBar(value: Boolean){
        if(value){
            binding.loadingIndicator.visibility = View.VISIBLE
        }else{
            binding.loadingIndicator.visibility = View.INVISIBLE
        }
    }


}