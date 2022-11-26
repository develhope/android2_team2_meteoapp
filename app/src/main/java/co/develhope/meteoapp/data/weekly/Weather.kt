package co.develhope.meteoapp.data.weekly

enum class Weather {
    SUNNY, CLOUDY, RAINY
}

fun Int.toWeather(): Weather {
    return when (this) {
        1 -> Weather.SUNNY
        else -> Weather.RAINY
    }
}