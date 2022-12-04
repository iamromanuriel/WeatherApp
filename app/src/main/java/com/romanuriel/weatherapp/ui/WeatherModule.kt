package com.romanuriel.weatherapp.ui

import com.romanuriel.weatherapp.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class WeatherModule {

    @FragmentScoped
    @Provides
    fun provedesWeatherModel(
        apiService: ApiService
    ): WeatherContract.Model{
        return WeatherModel(apiService)
    }
    @FragmentScoped
    @Provides
    fun provedesWeatherPrecenter(model: WeatherContract.Model):WeatherContract.Presenter{
        return WeatherPresenter(model)
    }
}