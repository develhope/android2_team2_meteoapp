package co.develhope.meteoapp.data

import org.threeten.bp.OffsetDateTime

sealed class TotalDataClass{
    data class SpecificDayHourly(val date: OffsetDateTime,
                                    val weather:String,
                                    val temp: Int,
                                    val pericip: Int):TotalDataClass()
    data class SpecificDayCard(val feelsLike: Int, val windSpeed:Double, val humidity: Int, val uVIndex:String,val cloudCover:Int, val rainAmount:Int):TotalDataClass()
    data class SpecificDayTitle1(val region:String, val city:String, val dayInfo:OffsetDateTime, val daySituation:String):TotalDataClass()
}
