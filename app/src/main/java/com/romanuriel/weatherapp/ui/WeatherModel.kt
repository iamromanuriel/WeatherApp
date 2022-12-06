package com.romanuriel.weatherapp.ui

import com.romanuriel.weatherapp.data.api.ApiService
import com.romanuriel.weatherapp.data.model.WeatherResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class WeatherModel(val apiService: ApiService):WeatherContract.Model {

    val publishsubjectweather = PublishSubject.create<String>()



    override fun getWeatherResponse(): Observable<WeatherResponse> {
        return apiService.getWeatherResponse()
    }

    override fun getStringTest(): Observable<String> {
        publishsubjectweather.onNext("elemento1")
        return publishsubjectweather
    }
}