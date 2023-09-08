package com.romanuriel.weatherapp.data.repository

import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import io.reactivex.Observable
import io.reactivex.Single
import java.util.Date


interface IRepositoryMain {

    fun getWeatherResponse(): Observable<WeatherResponse>

    fun getWeatherResponseWithSingle(): Single<WeatherResponse>

    fun getDate(): Observable<Date>
}