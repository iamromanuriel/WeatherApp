package com.romanuriel.weatherapp.data.api

import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import com.romanuriel.weatherapp.utils.API_KEY
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("weather?lat=19.0509656&lon=-98.1770116&appid=${API_KEY}")
    fun getWeatherResponse(): Observable<WeatherResponse>

    @GET("weather?lat=19.0509656&lon=-98.1770116&appid=${API_KEY}")
    fun getWeatherResponseWithSingle(): Single<WeatherResponse>


}