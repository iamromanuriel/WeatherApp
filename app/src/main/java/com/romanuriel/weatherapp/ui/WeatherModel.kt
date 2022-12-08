package com.romanuriel.weatherapp.ui

import com.romanuriel.weatherapp.data.api.ApiService
import com.romanuriel.weatherapp.data.model.WeatherResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class WeatherModel(val apiService: ApiService):WeatherContract.Model {

    private val  publishSubjectType = PublishSubject.create<Double>()



    override fun getWeatherResponse(): Observable<WeatherResponse> {
        return apiService.getWeatherResponse()
    }

    override fun setSelectDegrees(type: Double) {
        publishSubjectType.onNext(type)
    }

    override fun  getSelectDegrees(): PublishSubject<Double> {
        return publishSubjectType
    }
}