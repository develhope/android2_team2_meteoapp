package co.develhope.meteoapp.data.weekly

import com.google.gson.annotations.SerializedName


data class DailyUnits (

  @SerializedName("time"               ) var time             : String? = null,
  @SerializedName("weathercode"        ) var weathercode      : String? = null,
  @SerializedName("temperature_2m_max" ) var temperature2mMax : String? = null,
  @SerializedName("temperature_2m_min" ) var temperature2mMin : String? = null,
  @SerializedName("sunrise"            ) var sunrise          : String? = null,
  @SerializedName("sunset"             ) var sunset           : String? = null,
  @SerializedName("precipitation_sum"  ) var precipitationSum : String? = null,
  @SerializedName("rain_sum"           ) var rainSum          : String? = null

)