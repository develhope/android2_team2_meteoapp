package co.develhope.meteoapp.data.dataModel

enum class Weather {
    SUNNY, CLOUDY, RAINY
}

fun Int.toWeather(): Weather {
    return when (this) {
        0,1 -> Weather.SUNNY
        2,3 -> Weather.CLOUDY
        else -> Weather.RAINY
    }
}