package com.itacademy.retrofitrk

import android.app.Application
import com.itacademy.retrofitrk.data.Api
import com.itacademy.retrofitrk.data.RetrofitClient

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        services = RetrofitClient.getClient().create(Api::class.java)
    }
    companion object{
        var services: Api? = null
    }
}