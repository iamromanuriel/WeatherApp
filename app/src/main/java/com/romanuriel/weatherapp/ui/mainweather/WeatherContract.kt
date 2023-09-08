package com.romanuriel.weatherapp.ui.mainweather

import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import java.util.Date

interface WeatherContract{
    interface BasePresenterBinding<T>{
        fun onViewAttached(view: T)
        fun onViewDetach()
    }

    interface View{
        fun showWeather(weatherResponse: WeatherResponse)
        fun showProgressBar(value: Boolean)
        fun showMessage(msg: Any)

        fun showDate(date: String)
    }
    interface Presenter: BasePresenterBinding<View> {

        fun onStart()
        fun getWeather()
        fun getWeatherWithObserver()

        fun getWeatherWithSingle()
        fun getOptionDegrees(type:Double)

        fun getDate()
    }
    interface Model{
        fun getWeatherResponse(): Observable<WeatherResponse>
        fun getWeatherResponseWithSingle(): Single<WeatherResponse>

        fun getSelectDegrees(): PublishSubject<Double>
        fun setSelectDegrees(type: Double)

        fun getDate(): Observable<Date>
    }

}