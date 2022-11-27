package co.develhope.meteoapp.data.dataTransfer

data class CurrentWeather(

    var temperature     : Double,
    var windspeed       : Double,
    var winddirection   : Int,
    var weathercode     : Int,
    var time            : String
)