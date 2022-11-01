package co.develhope.meteoapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

     companion object {
         private const val BASE_URL = "https://api.open-meteo.com/"

         fun getRetrofitInstance(): Retrofit =
             Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
     }
}