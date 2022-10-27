package co.develhope.meteoapp.data

import co.develhope.meteoapp.SummaryForecast
import co.develhope.meteoapp.ForecastScreenItem

object ForecastModel {
    var list = ArrayList<ForecastScreenItem>()
    fun getForecastItems(): ArrayList<ForecastScreenItem> {
        list.add(ForecastScreenItem.Title("Palermo, Sicilia"))
        list.add(
            ForecastScreenItem.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        list.add(ForecastScreenItem.Subtitle("Next 5 days"))
        list.add(
            ForecastScreenItem.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        list.add(
            ForecastScreenItem.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        list.add(
            ForecastScreenItem.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        list.add(
            ForecastScreenItem.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        list.add(
            ForecastScreenItem.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        return list
    }
}