package com.romanuriel.weatherapp.ui

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class WeatherPresenter(val model: WeatherContract.Model): WeatherContract.Presenter{

    var view: WeatherContract.View? = null
    val disposable =  CompositeDisposable()

    override fun onViewAttached(view: WeatherContract.View) {
        this.view = view
    }

    override fun onViewDetach() {
        view = null
        disposable.clear()
    }

    override fun getWeather() {
        disposable.add(
            model.getWeatherResponse().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    view?.showWeather(it)
                },{
                    println(it.message)
                })
        )
    }

    override fun getuiStringTest() {
        disposable.add(
            model.getStringTest().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    println("Elementos de lista $it")
                },{
                    println(it.message)
                })
        )
    }



}