package com.romanuriel.weatherapp.ui

import com.romanuriel.weatherapp.data.api.ApiService
import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import com.romanuriel.weatherapp.data.repository.IRepositoryMain
import com.romanuriel.weatherapp.data.repository.RepositoryMain
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

class WeatherModel(private val repositoryMain: IRepositoryMain) : WeatherContract.Model {

    private val  publishSubjectType = PublishSubject.create<Double>()

    override fun getWeatherResponse(): Observable<WeatherResponse> {
        return repositoryMain.getWeatherResponse()
    }

    override fun getWeatherResponseWithSingle(): Single<WeatherResponse> {
        return repositoryMain.getWeatherResponseWithSingle()
    }

    override fun setSelectDegrees(type: Double) {
        publishSubjectType.onNext(type)
    }

    override fun  getSelectDegrees(): PublishSubject<Double> {
        return publishSubjectType
    }
}