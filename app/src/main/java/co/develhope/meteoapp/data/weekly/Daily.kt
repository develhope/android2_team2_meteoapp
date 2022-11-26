package co.develhope.meteoapp.data.weekly

import com.google.gson.annotations.SerializedName


data class Daily (

  @SerializedName("time"               ) var time             : ArrayList<String> = arrayListOf(),
  @SerializedName("weathercode"        ) var weathercode      : ArrayList<Int>    = arrayListOf(),
  @SerializedName("temperature_2m_max" ) var temperature2mMax : ArrayList<Double> = arrayListOf(),
  @SerializedName("temperature_2m_min" ) var temperature2mMin : ArrayList<Double> = arrayListOf(),
  @SerializedName("sunrise"            ) var sunrise          : ArrayList<String> = arrayListOf(),
  @SerializedName("sunset"             ) var sunset           : ArrayList<String> = arrayListOf(),
  @SerializedName("precipitation_sum"  ) var precipitationSum : ArrayList<Double> = arrayListOf(),
  @SerializedName("rain_sum"           ) var rainSum          : ArrayList<Double> = arrayListOf()

)