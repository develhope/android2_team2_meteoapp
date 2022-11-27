package co.develhope.meteoapp.data.dataTransfer

import org.threeten.bp.OffsetDateTime


data class Hourly (

  var time          : List<OffsetDateTime>,
  var temperature_2m: List<Double>,
  var rain          : List<Double>,
  var showers       : List<Double>,
  var snowfall      : List<Double>,
  var weathercode   : List<Int>,
  var windspeed_10m : List<Double>

)