package com.romanuriel.weatherapp.ui.mainweather

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.romanuriel.weatherapp.R
import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import com.romanuriel.weatherapp.databinding.FragmentMainWeatherBinding
import com.romanuriel.weatherapp.ui.BaseFragmentBinding
import com.romanuriel.weatherapp.ui.WeatherContract
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@AndroidEntryPoint
class MainFragmentWeather: BaseFragmentBinding<FragmentMainWeatherBinding>(),WeatherContract.View {
    @Inject
    lateinit var presenter: WeatherContract.Presenter

    override fun layout(): Int {
        return R.layout.fragment_main_weather
    }


    override fun initComponent(view: View, savedInstanceState: Bundle?) {
        presenter.onViewAttached(this)
        //weatherPresenter.getWeather()
        //weatherPresenter.getWeatherWithObserver()
        presenter.getWeatherWithSingle()
        showDialogOptiondegree()
    }

    override fun onDestroy() {
        presenter.onViewDetach()
        super.onDestroy()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun showWeather(weatherResponse: WeatherResponse) {
        val datetime = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("E, MMM dd yyyy"))

        val temp = weatherResponse.main.temp - 273.15
        val tempMin = weatherResponse.main.temp_min - 273.15
        val tempMax = weatherResponse.main.temp_max - 273.15
        binding.tvMessage.text = temp.toString()
        binding.txtDete.text = datetime
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
        showComponentProgressBar(value)
    }

    override fun showMessage(msg: Any) {
        showMessageWithToast(msg)
    }

    private fun showDialogOptiondegree() {
        binding.buttonSelectDegrees.setOnClickListener {
            DialogFragmentOptionDegrees().show(childFragmentManager, DialogFragmentOptionDegrees::class.java.simpleName)
        }
    }
}