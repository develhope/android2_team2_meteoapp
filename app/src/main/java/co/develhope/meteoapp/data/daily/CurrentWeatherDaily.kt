package co.develhope.meteoapp.data.daily

import com.google.gson.annotations.SerializedName


data class CurrentWeatherDaily (

  @SerializedName("temperature"   ) var temperature   : Double? = null,
  @SerializedName("windspeed"     ) var windspeed     : Double? = null,
  @SerializedName("winddirection" ) var winddirection : Int?    = null,
  @SerializedName("weathercode"   ) var weathercode   : Int?    = null,
  @SerializedName("time"          ) var time          : String? = null

)