package co.develhope.meteoapp.data.dataTransfer

data class HourlyUnits (

  var time          : String,
  var temperature_2m: String,
  var rain          : String,
  var showers       : String,
  var snowfall      : String,
  var weathercode   : String,
  var windspeed_10m  : String

)