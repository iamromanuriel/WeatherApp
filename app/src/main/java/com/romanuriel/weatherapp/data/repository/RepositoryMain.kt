package com.romanuriel.weatherapp.data.repository

import com.romanuriel.weatherapp.data.api.ApiService
import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import io.reactivex.Observable
import io.reactivex.Single
import java.util.Date
import java.util.concurrent.TimeUnit

class RepositoryMain(
    private val apiService: ApiService
): IRepositoryMain {
    override fun getWeatherResponse(): Observable<WeatherResponse> {
        return apiService.getWeatherResponse()
    }

    override fun getWeatherResponseWithSingle(): Single<WeatherResponse> {
        return apiService.getWeatherResponseWithSingle()
    }

    override fun getDate(): Observable<Date> {
        return Observable.interval(1,TimeUnit.SECONDS)
            .map { tick -> Date() }
    }
}