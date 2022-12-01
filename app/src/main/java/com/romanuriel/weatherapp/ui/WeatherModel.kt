package com.romanuriel.weatherapp.ui

import com.romanuriel.weatherapp.data.api.ApiService
import com.romanuriel.weatherapp.data.model.WeatherResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WeatherModel(val apiService: ApiService):WeatherContract.Model {

    override fun getWeatherResponse(): Observable<WeatherResponse> {
        return apiService.getWeatherResponse()
    }
}