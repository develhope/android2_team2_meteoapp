package co.develhope.meteoapp.data

import android.icu.text.SimpleDateFormat
import co.develhope.meteoapp.ForecastScreenItem
import co.develhope.meteoapp.SummaryForecast
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.OffsetTime

object SpecificDayForecastItems {
    fun getSpecificDayForecastItem(): ArrayList<TotalDataClass>{
        val list = ArrayList<TotalDataClass>()
        list.add(TotalDataClass.SpecificDayTitle1("Palermo", city = "Sicilia", dayInfo = OffsetDateTime.now(), daySituation = " " ))

        list.add((TotalDataClass.SpecificDayCard(feelsLike =2 , windSpeed = 30.56, humidity = 89, uVIndex = " ", cloudCover = 5, rainAmount = 60)))
        list.add((TotalDataClass.SpecificDayHourly(date =OffsetDateTime.now(), weather = " ", temp = 0,pericip=10 )))
        list.add((TotalDataClass.SpecificDayHourly(date =OffsetDateTime.now(), weather = " ", temp = 0,pericip=10 )))
        list.add((TotalDataClass.SpecificDayHourly(date =OffsetDateTime.now(), weather = " ", temp = 0,pericip=10 )))
        list.add((TotalDataClass.SpecificDayHourly(date =OffsetDateTime.now(), weather = " ", temp = 0,pericip=10 )))
        list.add((TotalDataClass.SpecificDayHourly(date =OffsetDateTime.now(), weather = " ", temp = 0,pericip=10 )))
        list.add((TotalDataClass.SpecificDayHourly(date =OffsetDateTime.now(), weather = " ", temp = 0,pericip=10 )))
        list.add((TotalDataClass.SpecificDayHourly(date =OffsetDateTime.now(), weather = " ", temp = 0,pericip=10 )))
        list.add((TotalDataClass.SpecificDayHourly(date =OffsetDateTime.now(), weather = " ", temp = 0,pericip=10 )))
        list.add((TotalDataClass.SpecificDayHourly(date =OffsetDateTime.now(), weather = " ", temp = 0,pericip=10 )))

        return  list
    }
}