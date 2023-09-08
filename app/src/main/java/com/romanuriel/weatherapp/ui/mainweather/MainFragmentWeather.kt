package com.romanuriel.weatherapp.ui.mainweather

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.romanuriel.weatherapp.R
import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import com.romanuriel.weatherapp.databinding.FragmentMainWeatherBinding
import com.romanuriel.weatherapp.ui.BaseFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragmentWeather: BaseFragmentBinding<FragmentMainWeatherBinding>(), WeatherContract.View {
    @Inject
    lateinit var presenter: WeatherContract.Presenter

    override fun layout(): Int {
        return R.layout.fragment_main_weather
    }


    override fun initComponent(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached(this)
        presenter.onStart()
    }

    override fun onDestroy() {
        presenter.onViewDetach()
        super.onDestroy()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun showWeather(weatherResponse: WeatherResponse) {

        val temp = weatherResponse.main.temp - 273.15
        val tempMin = weatherResponse.main.temp_min - 273.15
        val tempMax = weatherResponse.main.temp_max - 273.15
        binding.tvMessage.text = temp.toString()
        binding.txtNameCity.text = weatherResponse.name
        binding.txtTxmpMin.text = tempMin.toString()
        binding.txtTxmpMax.text = tempMax.toString()
        binding.txtHumi.text = weatherResponse.main.humidity.toString()

        //new date

        binding.txtFeelsLike.text = weatherResponse.main.feels_like.toString()
        binding.txtTxmpGrndLevel.text = weatherResponse.main.grnd_level.toString()
        binding.txtPressure.text = weatherResponse.main.pressure.toString()


    }

    override fun showProgressBar(value: Boolean) {
        if(value){binding.loading.visibility = View.VISIBLE}
        else{ binding.loading.visibility = View.GONE}
    }

    override fun showMessage(msg: Any) {
        showMessageWithToast(msg)
    }

    override fun showDate(date: String) {
        binding.txtDete.text = date
    }


}