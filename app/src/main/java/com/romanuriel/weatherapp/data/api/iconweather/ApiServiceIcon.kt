package com.romanuriel.weatherapp.data.api.iconweather

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiServiceIcon {
    @GET("img/wn/10d@2x.png")
    fun getIcon(): Observable<String>
}