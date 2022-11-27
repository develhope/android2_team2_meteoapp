package co.develhope.meteoapp.data

import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.weekly.Weather

object ForecastModel {

    fun setIcon(weather: Weather): Int {
        return when (weather){
            Weather.SUNNY -> R.drawable.ic_sun
            Weather.RAINY -> R.drawable.ic_raining
            Weather.CLOUDY -> R.drawable.ic_sun_cloud
        }
    }

    fun setDayOfWeek(dayOfWeek: String): String {
        return when (dayOfWeek) {
            "MONDAY" -> "Monday"
            "TUESDAY" -> "Tuesday"
            "WEDNESDAY" -> "Wednesday"
            "THURSDAY" -> "Thursday"
            "FRIDAY" -> "Friday"
            "SATURDAY" -> "Saturday"
            "SUNDAY" -> "Sunday"
            else -> "Unknown"
        }
    }
}