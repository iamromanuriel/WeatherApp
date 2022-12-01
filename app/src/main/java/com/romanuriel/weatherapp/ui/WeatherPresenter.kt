package com.romanuriel.weatherapp.ui

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(val model: WeatherContract.Model): WeatherContract.Presenter{

    var view: WeatherContract.View? = null

    override fun onViewAttached(view: WeatherContract.View) {
        this.view = view
    }

    override fun getWeather() {
        CompositeDisposable().add(
            model.getWeatherResponse().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    view?.showWeather(it)
                },{
                    println(it.message)
                })
        )
    }


}