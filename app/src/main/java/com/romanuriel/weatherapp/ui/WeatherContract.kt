package com.romanuriel.weatherapp.ui

import com.romanuriel.weatherapp.data.model.WeatherResponse
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject

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
        fun getOptionDegrees(type:Double)
    }
    interface Model{
        fun getWeatherResponse(): Observable<WeatherResponse>
        fun getSelectDegrees(): PublishSubject<Double>
        fun setSelectDegrees(type: Double)
    }

}