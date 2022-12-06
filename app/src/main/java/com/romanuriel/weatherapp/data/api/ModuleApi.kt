package com.romanuriel.weatherapp.data.api

import com.romanuriel.weatherapp.utils.BASE_URL_WEATHER
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ModuleApi {

    @Singleton
    @Provides
    fun provederApiWeather(): Retrofit{
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_WEATHER)
            .build()
    }

    @Singleton
    @Provides
    fun providerApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }
}