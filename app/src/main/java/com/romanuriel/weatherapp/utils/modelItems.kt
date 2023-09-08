package com.romanuriel.weatherapp.utils

data class DegreesModel(
    val type: String,
    val value: Double,
    val select: Boolean
)

enum class TypeDegree(val value: Double){
    FAHRENHEIT(32.0),
    KELVIN(273.15),
    CELSIUS(0.0)
}