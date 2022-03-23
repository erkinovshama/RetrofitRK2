package com.itacademy.retrofitrk.data

import com.itacademy.retrofitrk.models.WeatherResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("weather")
    fun getWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") appid: String
    ) : Call<WeatherResponseModel>
}