package com.romanuriel.weatherapp.data.repository

import com.romanuriel.weatherapp.data.api.ApiService
import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import io.reactivex.Observable
import io.reactivex.Single

class RepositoryMain(
    private val apiService: ApiService
): IRepositoryMain {
    override fun getWeatherResponse(): Observable<WeatherResponse> {
        return apiService.getWeatherResponse()
    }

    override fun getWeatherResponseWithSingle(): Single<WeatherResponse> {
        return apiService.getWeatherResponseWithSingle()
    }

}