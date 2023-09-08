package com.romanuriel.weatherapp.ui.mainweather

import android.annotation.SuppressLint
import android.util.Log
import com.romanuriel.weatherapp.data.api.results.WeatherResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(val model: WeatherContract.Model): WeatherContract.Presenter {

    var view: WeatherContract.View? = null
    val disposable =  CompositeDisposable() // referencia a una operacion de subcripcion (cancelar o liberar recursos)

    override fun onViewAttached(view: WeatherContract.View) {
        this.view = view
    }

    override fun onViewDetach() {
        view = null
        disposable.clear()
    }


    @SuppressLint("CheckResult")
    override fun onStart() {
        disposable.add(
            model.getDate().
            subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { view?.showProgressBar(false) }
                .subscribe({
                           view?.showDate(it.toString())
                    model.getWeatherResponse()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doFinally { view?.showProgressBar(false) }
                        .subscribe({
                                   view?.showWeather(it)
                        },{
                            view?.showMessage(it.localizedMessage?:"")
                        })
                },{
                    view?.showMessage(it.localizedMessage?:"")
                })
        )
    }

    override fun getWeather() {//With Observarble
        disposable.add(
            model.getWeatherResponse()
                .subscribeOn(Schedulers.io())// Inidica en que subproceso relizara la operacion de subsicripcion
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{ view?.showProgressBar(true) }
                .doFinally { view?.showProgressBar(false) }
                .subscribe({//indica en que subproceso realizara la entrega de subcripcion
                    view?.showWeather(it)
                }, {
                    view?.showMessage(it.localizedMessage?:"Error no controlado")
                })
        )
    }




    override fun getWeatherWithObserver() {
        val observable = model.getWeatherResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val observer = object : Observer<WeatherResponse>{
            override fun onSubscribe(d: Disposable) {
                //Se llama cuando se conecta al observable
                disposable.add(d)
                view?.showProgressBar(true)
            }

            override fun onError(e: Throwable) {
                // Se llama cuando ocurre un error
                view?.showMessage(e.localizedMessage)
                view?.showProgressBar(false)
            }

            override fun onComplete() {
                // Se llama cuando e observable completa
                view?.showProgressBar(false)
            }

            override fun onNext(t: WeatherResponse) {
                //Se llama cuando recibe el observable
                view?.showWeather(t)
            }
        }

        observable.subscribe(observer) //subcribe al observer
    }

    override fun getWeatherWithSingle() {
        disposable.add(
            model.getWeatherResponseWithSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view?.showProgressBar(true) }
                .doFinally { view?.showProgressBar(false) }
                .subscribe({weatherResponse ->

                    view?.showWeather(weatherResponse)
                },{error ->
                    view?.showMessage(error.localizedMessage?: "Error no controlado")
                })
        )
    }

    override fun getDate() {
        disposable.add(
            model.getDate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view?.showProgressBar(true) }
                .doFinally { view?.showProgressBar(false) }
                .subscribe({
                           view?.showDate(it.toString())
                },{
                    view?.showMessage(it.localizedMessage?:"")
                })
        )
    }


    override fun getOptionDegrees(type: Double) {


    }


}