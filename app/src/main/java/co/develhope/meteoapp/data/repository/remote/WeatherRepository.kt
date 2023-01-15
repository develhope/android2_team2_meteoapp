package co.develhope.meteoapp.data.repository.remote

import co.develhope.meteoapp.network.RetrofitLocation


/**
 * Created by Soumik Bhattacharjee on 9/13/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class WeatherRepository {

    suspend fun getWeatherByLocation(lat:String,lon:String) = RetrofitLocation.apiService.getWeatherByLocation(lat,lon)
    suspend fun getWeatherByCityID(id:String) = RetrofitLocation.apiService.getWeatherByCityID(id)
}