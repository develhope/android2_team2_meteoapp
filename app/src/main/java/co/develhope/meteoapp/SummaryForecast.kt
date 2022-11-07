package co.develhope.meteoapp

data class SummaryForecast(
    val minTemp:String,
    val maxTemp:String,
    val precipitation:String,
    val wind:String,
    val icon: Int,
    val days:String,
    val date:String,
    val minTxt:String,
    val maxTxt:String,
    val windTxt:String,
    val precipitationTxt:String) {
}

sealed class ForecastScreenItem {
    data class Forecast(val summaryForecast: SummaryForecast) : ForecastScreenItem()
    data class Title(val title: String) : ForecastScreenItem()
    data class Subtitle(val subTitle: String) : ForecastScreenItem()
}

