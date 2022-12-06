package com.romanuriel.weatherapp.ui

import com.romanuriel.weatherapp.data.model.WeatherResponse
import io.reactivex.Observable

interface WeatherContract{
    interface BasePresenterBinding<T>{
        fun onViewAttached(view: T)
        fun onViewDetach()
    }

    interface View{
        fun showWeather(weatherResponse: WeatherResponse)
    }
    interface Presenter: BasePresenterBinding<View>{
        fun getWeather()
        fun getuiStringTest()
    }
    interface Model{
        fun getWeatherResponse(): Observable<WeatherResponse>
        fun getStringTest(): Observable<String>
    }

}