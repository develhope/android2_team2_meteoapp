package co.develhope.meteoapp.data

import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.dataModel.DailyForecast
import co.develhope.meteoapp.data.dataModel.Weather
import org.threeten.bp.OffsetDateTime

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

    private val dailyWeatherList: List<DailyForecast> = listOf(
        DailyForecast(OffsetDateTime.now(), Weather.SUNNY, 30, 0),
        DailyForecast(OffsetDateTime.now().plusHours(1), Weather.SUNNY, 30, 0),
        DailyForecast(OffsetDateTime.now().plusHours(2), Weather.CLOUDY, 28, 0),
        DailyForecast(OffsetDateTime.now().plusHours(3), Weather.SUNNY, 29, 0),
        DailyForecast(OffsetDateTime.now().plusHours(4), Weather.SUNNY, 30, 0),
        DailyForecast(OffsetDateTime.now().plusHours(5), Weather.SUNNY, 28, 0),
        DailyForecast(OffsetDateTime.now().plusHours(6), Weather.CLOUDY, 26, 15),
        DailyForecast(OffsetDateTime.now().plusHours(7), Weather.RAINY, 25, 60),
        DailyForecast(OffsetDateTime.now().plusHours(8), Weather.RAINY, 25, 80),
        DailyForecast(OffsetDateTime.now().plusHours(9), Weather.RAINY, 23, 100),
        DailyForecast(OffsetDateTime.now().plusHours(10), Weather.RAINY, 24, 100),
        DailyForecast(OffsetDateTime.now().plusHours(11), Weather.RAINY, 23, 100),
        DailyForecast(OffsetDateTime.now().plusHours(12), Weather.RAINY, 26, 98)
    )

    fun getDailyWeatherList(): List<DailyForecast> {
        return dailyWeatherList
    }
}