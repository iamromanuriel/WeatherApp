package com.romanuriel.weatherapp.ui.detailsweather

import com.romanuriel.weatherapp.R
import com.romanuriel.weatherapp.data.model.WeatherResponse
import com.romanuriel.weatherapp.databinding.FragmentMainWeatherBinding
import com.romanuriel.weatherapp.ui.BaseFragmentBinding
import com.romanuriel.weatherapp.ui.WeatherContract

class DetailFragmentWeather: BaseFragmentBinding<FragmentMainWeatherBinding>(){

    override fun layout(): Int {
        return R.layout.fragment_detail_weather
    }
}