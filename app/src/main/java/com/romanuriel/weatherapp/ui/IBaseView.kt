package com.romanuriel.weatherapp.ui

interface IBaseView {
    fun showComponentProgressBar(value: Boolean)
    fun showMessageWithToast(message: Any)
    fun showMessageWithSnackbar(message: Any)
    fun initDebug(value: Any)
}