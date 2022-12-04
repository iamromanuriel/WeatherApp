package com.romanuriel.weatherapp.ui

import com.romanuriel.weatherapp.data.model.WeatherResponse
import io.reactivex.Observable

interface WeatherContract{
    interface BasePresenterBinding<T>{
        fun onViewAttached(view: T)
    }

    interface View{
        fun showWeather(weatherResponse: WeatherResponse)

    }
    interface Presenter: BasePresenterBinding<View>{
        fun getWeather()
    }
    interface Model{
        fun getWeatherResponse(): Observable<WeatherResponse>
    }

}