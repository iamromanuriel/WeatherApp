package com.romanuriel.weatherapp.data.repository

import com.romanuriel.weatherapp.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class MainRepositoryModule {

    @FragmentScoped
    @Provides
    fun providesMainRepository(
        apiService: ApiService
    ): IRepositoryMain{
        return RepositoryMain(apiService)
    }
}