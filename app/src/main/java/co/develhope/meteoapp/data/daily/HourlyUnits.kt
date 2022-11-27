package co.develhope.meteoapp.data.daily

import com.google.gson.annotations.SerializedName


data class HourlyUnits (

  @SerializedName("time"           ) var time          : String? = null,
  @SerializedName("temperature_2m" ) var temperature2m : String? = null,
  @SerializedName("rain"           ) var rain          : String? = null,
  @SerializedName("showers"        ) var showers       : String? = null,
  @SerializedName("snowfall"       ) var snowfall      : String? = null,
  @SerializedName("weathercode"    ) var weathercode   : String? = null,
  @SerializedName("windspeed_10m"  ) var windspeed10m  : String? = null

)