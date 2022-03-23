package com.itacademy.retrofitrk

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.itacademy.retrofitrk.dataclass.Location
import com.itacademy.retrofitrk.dictionaries.Constants
import com.itacademy.retrofitrk.models.WeatherResponseModel
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val cities = arrayListOf(
        Location("Бишкек", 42.8768537, 74.521821),
        Location("Талас", 42.5299875, 72.1879001),
        Location("Баткен", 40.0575553, 70.788302)
    )

     private var location: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cityName: TextView = findViewById(R.id.cityName)
        val temperature: TextView = findViewById(R.id.temperature)
        val button: Button = findViewById(R.id.button)
        val spinner: Spinner = findViewById(R.id.spinner)
        val image: ImageView = findViewById(R.id.imageView)
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)

        button.setOnClickListener {
            location = spinner.selectedItem as Location
            App.services?.getWeather(location?.lat!!, location?.lon!!, Constants.APP_ID)
                ?.enqueue(object : Callback<WeatherResponseModel> {
                    override fun onResponse(
                        call: Call<WeatherResponseModel>,
                        response: Response<WeatherResponseModel>
                    ) {
                        cityName.text = response.body()?.name
                        temperature.text = response.body()?.main?.temp.toString()
                        setImageView(response.body()!!.weather[0].icon, image)
                    }

                    override fun onFailure(call: Call<WeatherResponseModel>, t: Throwable) {
                        Log.e("Error", t.localizedMessage)
                    }
                })
        }
    }

    fun setImageView(image: String, view: ImageView) {
        val url = "https://openweathermap.org/img/wn/"
        Picasso.Builder(this).build().load("$url$image@2x.png").into(view)

    }
}