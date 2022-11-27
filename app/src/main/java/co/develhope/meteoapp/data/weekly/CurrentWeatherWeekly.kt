package co.develhope.meteoapp.data.weekly

import com.google.gson.annotations.SerializedName


data class CurrentWeatherWeekly (

  @SerializedName("temperature"   ) var temperature   : Int?    = null,
  @SerializedName("windspeed"     ) var windspeed     : Double? = null,
  @SerializedName("winddirection" ) var winddirection : Int?    = null,
  @SerializedName("weathercode"   ) var weathercode   : Int?    = null,
  @SerializedName("time"          ) var time          : String? = null
)