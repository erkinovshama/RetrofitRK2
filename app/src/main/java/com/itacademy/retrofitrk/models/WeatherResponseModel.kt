package com.itacademy.retrofitrk.models

data class WeatherResponseModel(
    val coord: Coordinates,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: String,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Int,
    val sys: Sys,
    val timeZone: Int,
    val id: Int,
    val name: String,
    val cod: Int
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Coordinates(
    val lon: Double,
    val lat: Double
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int
)

data class Wind(
    val speed: Double,
    val deg: Int,
)

data class Clouds(
    val all: Int,
)

data class Sys(
    val type: Int,
    val message: Double,
    val country: String,
    val sunrise: Int,
    val sunset: Int
)
