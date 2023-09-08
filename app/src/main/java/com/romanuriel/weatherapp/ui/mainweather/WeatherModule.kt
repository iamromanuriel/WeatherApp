package com.romanuriel.weatherapp.ui.mainweather

import com.romanuriel.weatherapp.data.repository.IRepositoryMain
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class WeatherModule {

    @FragmentScoped
    @Provides
    fun provedesWeatherModel(
        repositoryMain: IRepositoryMain
    ): WeatherContract.Model {
        return WeatherModel(repositoryMain)
    }
    @FragmentScoped
    @Provides
    fun provedesWeatherPrecenter(model: WeatherContract.Model): WeatherContract.Presenter {
        return WeatherPresenter(model)
    }
}