package com.romanuriel.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.romanuriel.weatherapp.data.model.WeatherResponse
import com.romanuriel.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),WeatherContract.View {
    @Inject lateinit var weatherPresenter: WeatherContract.Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        weatherPresenter.onViewAttached(this)
        weatherPresenter.getWeather()
    }

    override fun showWeather(weatherResponse: WeatherResponse) {
        val temp = weatherResponse.main.temp - 273.15
        binding.tvMessage.text = temp.toString()
        binding.txtDete.text = weatherResponse.base
        binding.txtNameCity.text = weatherResponse.name

    }


}