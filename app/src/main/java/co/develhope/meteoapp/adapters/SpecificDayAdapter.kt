package co.develhope.meteoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.ForecastModel
import co.develhope.meteoapp.data.dataModel.DailyScreenItems
import co.develhope.meteoapp.databinding.DayHourlyItemBinding
import co.develhope.meteoapp.databinding.SpecificDayCardViewBinding
import co.develhope.meteoapp.databinding.SpecificDayTitleBinding

class SpecificDayAdapter(private val newList: List<DailyScreenItems>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (newList[position]) {
            is DailyScreenItems.CardForecast -> HOURLY_CARD
            is DailyScreenItems.HourlyForecast -> HOURLY_HOURLY
            is DailyScreenItems.Title -> HOURLY_TITLE

        }
    }


    class SpecificDayTitleViewHolder(private val specificDayTitle: SpecificDayTitleBinding) :
        RecyclerView.ViewHolder(specificDayTitle.root) {
        fun bind(title: DailyScreenItems.Title) {
            specificDayTitle.dayTitle.text = itemView.context.getString(
                R.string.palermo_sic,
                title.city,
                title.region
            )
            specificDayTitle.dayDescriptionTxt.text = itemView.context.getString(
                R.string.specificDay_date,
                title.date.dayOfMonth,
                title.date.monthValue,
                title.date.year
            )
        }
    }

    class SpecificDayCardViewHolder(private val specificDayCard: SpecificDayCardViewBinding) :
        RecyclerView.ViewHolder(specificDayCard.root) {
        fun bind(cardItems: DailyScreenItems.CardForecast) {
            specificDayCard.tvDayPrecipitationGrade.text = itemView.context.getString(
                R.string.specificDay_precipitation_grade, cardItems.cardForecast.precip)
            specificDayCard.cardUvIndex.text = itemView.context.getString(
                R.string.specificDay_uvIndex, cardItems.cardForecast.index)
            specificDayCard.dayHumidityGrade.text = itemView.context.getString(
                R.string.specificDay_hum_grade,cardItems.cardForecast.humidity)
            specificDayCard.dayWindSpeed.text = itemView.context.getString(
                R.string.specificDay_wind_speed, cardItems.cardForecast.wind)
            specificDayCard.dayCoveragePer.text = itemView.context.getString(
                R.string.specificDay_coverage_percent, cardItems.cardForecast.coverage)
            specificDayCard.dayRainPer.text = itemView.context.getString(
                R.string.specificDay_rain_mm, cardItems.cardForecast.rainfall
            )
        }
    }

    class SpecificDayHourlyViewHolder(private val specificHourly: DayHourlyItemBinding) :
        RecyclerView.ViewHolder(specificHourly.root) {
        fun bind(hourlyItems: DailyScreenItems.HourlyForecast) {
            specificHourly.dayHour2.text = itemView.context.getString(
                R.string.specificDay_hour_second,hourlyItems.hourlyForecast.date.hour)
            specificHourly.dayIconMoon.setImageResource(
                ForecastModel.setIcon(hourlyItems.hourlyForecast.weather))
            specificHourly.dayGrade.text = itemView.context.getString(
                R.string.SpecificDay_grade, hourlyItems.hourlyForecast.temperature)
            specificHourly.dayHumidityPercent.text = itemView.context.getString(R.string.specificDay_humidity_percent,
            hourlyItems.hourlyForecast.rainfall)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {

            HOURLY_TITLE -> SpecificDayTitleViewHolder (
                    SpecificDayTitleBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false))
            HOURLY_CARD -> SpecificDayCardViewHolder (
                    SpecificDayCardViewBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false))

            HOURLY_HOURLY -> SpecificDayHourlyViewHolder (
                    DayHourlyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

                )

            else -> throw java.lang.IllegalArgumentException("Invalid view")

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SpecificDayTitleViewHolder -> holder.bind(newList[position] as DailyScreenItems.Title)
            is SpecificDayCardViewHolder -> holder.bind(newList[position] as DailyScreenItems.CardForecast)
            is SpecificDayHourlyViewHolder -> holder.bind(newList[position] as DailyScreenItems.HourlyForecast)
        }
    }


    override fun getItemCount(): Int = newList.size

    companion object {
        const val HOURLY_TITLE = 0
        const val HOURLY_CARD = 1
        const val HOURLY_HOURLY = 2
    }
}