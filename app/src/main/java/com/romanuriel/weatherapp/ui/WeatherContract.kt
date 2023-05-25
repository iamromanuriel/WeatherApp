package com.romanuriel.weatherapp.ui

import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

interface WeatherContract{
    interface BasePresenterBinding<T>{
        fun onViewAttached(view: T)
        fun onViewDetach()
    }

    interface View{
        fun showWeather(weatherResponse: WeatherResponse)
        fun showProgressBar(value: Boolean)
        fun showMessage(msg: Any)
    }
    interface Presenter: BasePresenterBinding<View>{
        fun getWeather()
        fun getWeatherWithObserver()

        fun getWeatherWithSingle()
        fun getOptionDegrees(type:Double)
    }
    interface Model{
        fun getWeatherResponse(): Observable<WeatherResponse>
        fun getWeatherResponseWithSingle(): Single<WeatherResponse>

        fun getSelectDegrees(): PublishSubject<Double>
        fun setSelectDegrees(type: Double)
    }

}