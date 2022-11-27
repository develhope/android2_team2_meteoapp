package co.develhope.meteoapp.data.dataModel

import org.threeten.bp.OffsetDateTime

data class DailyForecast(

    val date: OffsetDateTime,
    val weather: Weather,
    val temperature: Int,
    val rainfall: Int
)
data class CardForecastDetails(
    val precip: Double,
    val index: Double,
    val humidity: Double,
    val wind: Double,
    val coverage: Int,
    val rainfall: Double
)

sealed class DailyScreenItems {

    data class HourlyForecast(val hourlyForecast: DailyForecast) : DailyScreenItems()
    data class CardForecast(val cardForecast: CardForecastDetails): DailyScreenItems()
    data class Title(val date: OffsetDateTime, val city: String, val region: String) : DailyScreenItems()
}

