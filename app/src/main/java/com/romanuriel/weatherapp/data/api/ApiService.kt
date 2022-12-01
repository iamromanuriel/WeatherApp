package com.romanuriel.weatherapp.data.api

import com.romanuriel.weatherapp.data.model.WeatherResponse
import com.romanuriel.weatherapp.utils.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("weather?lat=19.0509656&lon=-98.1770116&appid=${API_KEY}")
    fun getWeatherResponse(): Observable<WeatherResponse>
}