package co.develhope.meteoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.ForecastModel
import co.develhope.meteoapp.data.dataModel.DailyScreenItems
import co.develhope.meteoapp.databinding.*

class TomorrowScrAdapter(private val newList: List<DailyScreenItems>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (newList[position]) {
            is DailyScreenItems.CardForecast -> TOM_CARD
            is DailyScreenItems.HourlyForecast -> TOM_HOURLY
            is DailyScreenItems.Title -> TOM_TITLE

        }
    }
    class TomTitleViewHolder(private val tomTitle: TomTitleBinding) :
        RecyclerView.ViewHolder(tomTitle.root) {
        fun bind(title: DailyScreenItems.Title) {
            tomTitle.tomTitle.text = itemView.context.getString(
                R.string.palermo_sic,
                title.city,
                title.region
            )
            tomTitle.tomDayTxt.text = itemView.context.getString(
                R.string.specificDay_date,
                title.date.dayOfMonth,
                title.date.monthValue,
                title.date.year
            )
        }
    }

    class TomCardViewHolder(private val tomCard: TomCardViewBinding) :
        RecyclerView.ViewHolder(tomCard.root) {
        fun bind(cardItems: DailyScreenItems.CardForecast) {
            tomCard.tvTomPrecipitationGrade.text = itemView.context.getString(
                R.string.precipitation_grade, cardItems.cardForecast.precip)
            tomCard.tvTomUvIndexTxt.text = itemView.context.getString(
                R.string.uv_index, cardItems.cardForecast.index)
            tomCard.tomHumidity.text = itemView.context.getString(
                R.string.tom_hum_grade,cardItems.cardForecast.humidity)
            tomCard.tomWindSpeed.text = itemView.context.getString(
                R.string.wind_speed, cardItems.cardForecast.wind)
            tomCard.tomCoveragePer.text = itemView.context.getString(
                R.string.coverage_percent, cardItems.cardForecast.coverage)
            tomCard.tomRainPer.text = itemView.context.getString(
                R.string.rain_mm, cardItems.cardForecast.rainfall
            )
        }
    }

    class TomHourlyViewHolder(private val tomHourly: TomHourlyItemBinding) :
        RecyclerView.ViewHolder(tomHourly.root) {
        fun bind(hourlyItems: DailyScreenItems.HourlyForecast) {
            tomHourly.tom2Hour.text = itemView.context.getString(
                R.string.hour,hourlyItems.hourlyForecast.date.hour)
            tomHourly.tom2IconMoon.setImageResource(
                ForecastModel.setIcon(hourlyItems.hourlyForecast.weather))
            tomHourly.tom2Grade.text = itemView.context.getString(
                R.string.tom_grade, hourlyItems.hourlyForecast.temperature)
            tomHourly.tom2HumidityPercent.text = itemView.context.getString(R.string.humidity_percent,
                hourlyItems.hourlyForecast.rainfall)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {

            TOM_TITLE -> TomTitleViewHolder (
                TomTitleBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false))
            TOM_CARD -> TomCardViewHolder (
                TomCardViewBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false))

            TOM_HOURLY -> TomHourlyViewHolder (
                TomHourlyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            )

            else -> throw java.lang.IllegalArgumentException("Invalid view")

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TomTitleViewHolder -> holder.bind(newList[position] as DailyScreenItems.Title)
            is TomCardViewHolder -> holder.bind(newList[position] as DailyScreenItems.CardForecast)
            is TomHourlyViewHolder -> holder.bind(newList[position] as DailyScreenItems.HourlyForecast)
        }
    }


    override fun getItemCount(): Int = newList.size

    companion object {
        const val TOM_TITLE = 0
        const val TOM_CARD = 1
        const val TOM_HOURLY = 2
    }
}