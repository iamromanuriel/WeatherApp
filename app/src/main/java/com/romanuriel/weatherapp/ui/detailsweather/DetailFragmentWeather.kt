package com.romanuriel.weatherapp.ui.detailsweather

import android.os.Bundle
import android.view.View
import com.romanuriel.weatherapp.R
import com.romanuriel.weatherapp.databinding.FragmentMainWeatherBinding
import com.romanuriel.weatherapp.ui.BaseFragmentBinding

class DetailFragmentWeather: BaseFragmentBinding<FragmentMainWeatherBinding>(){

    override fun layout(): Int {
        return R.layout.fragment_detail_weather
    }

    override fun initComponent(view: View, savedInstanceState: Bundle?) {

    }
}