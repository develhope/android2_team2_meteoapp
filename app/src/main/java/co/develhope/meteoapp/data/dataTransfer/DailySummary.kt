package co.develhope.meteoapp.data.dataTransfer

data class DailySummary (

  var latitude             : Double,
  var longitude            : Double,
  var generationtimeMs     : Double,
  var utcOffsetSeconds     : Int,
  var timezone             : String,
  var timezoneAbbreviation : String,
  var elevation            : Int,
  var currentWeatherDaily  : CurrentWeather,
  var hourlyUnits          : HourlyUnits,
  var hourly               : Hourly

)