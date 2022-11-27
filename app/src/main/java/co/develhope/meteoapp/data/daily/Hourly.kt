package co.develhope.meteoapp.data.daily

import com.google.gson.annotations.SerializedName


data class Hourly (

  @SerializedName("time"           ) var time          : ArrayList<String> = arrayListOf(),
  @SerializedName("temperature_2m" ) var temperature2m : ArrayList<Double> = arrayListOf(),
  @SerializedName("rain"           ) var rain          : ArrayList<Int>    = arrayListOf(),
  @SerializedName("showers"        ) var showers       : ArrayList<Int>    = arrayListOf(),
  @SerializedName("snowfall"       ) var snowfall      : ArrayList<Int>    = arrayListOf(),
  @SerializedName("weathercode"    ) var weathercode   : ArrayList<Int>    = arrayListOf(),
  @SerializedName("windspeed_10m"  ) var windspeed10m  : ArrayList<Int>    = arrayListOf()

)