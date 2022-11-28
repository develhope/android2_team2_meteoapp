package co.develhope.meteoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.TodayDataClass
import co.develhope.meteoapp.databinding.TodayCardViewBinding
import co.develhope.meteoapp.databinding.TodayHeaderBinding
import co.develhope.meteoapp.databinding.TodayHourlyItemBinding

class TodayScreenAdopter(private val newList: List<TodayDataClass>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (newList[position]) {
            is TodayDataClass.TodayHeaderClass -> TodayScreenAdopter.HEADER
            is TodayDataClass.TodayCardViewClass -> TodayScreenAdopter.CARD
            is TodayDataClass.TodayHourlyClass -> TodayScreenAdopter.HOURLY
        }
    }

    class TodayHeaderViewHolder(private val todayHeader: TodayHeaderBinding) :
        RecyclerView.ViewHolder(todayHeader.root) {
        fun bind(title: TodayDataClass.TodayHeaderClass) {
            todayHeader.todayTitle.text = itemView.context.getString(R.string.td_palermo_sic, title.regin, title.city)
            //todayHeader.tdDayTxt.text = itemView.context.getString(R.string.td_text_date, title.todayDate)
            todayHeader.tdInfoTxt.text = itemView.context.getString(R.string.td_Info, title.todayInfo)
        }
    }

    class TodayCardViewHolder(private val todayCard: TodayCardViewBinding) :
        RecyclerView.ViewHolder(todayCard.root) {
        fun bind(title: TodayDataClass.TodayCardViewClass) {
            todayCard.tvTdPrecipitationGrade.text =
                itemView.context.getString(R.string.td_precipitation_grade, title.feelsLike)
            todayCard.tdUvIndex.text = itemView.context.getString(R.string.td_index, title.uvIndex)
            todayCard.tdHumidityGrade.text =
                itemView.context.getString(R.string.td_hum_grade, title.humidity)
            todayCard.tdWindSpeed.text =
                itemView.context.getString(R.string.td_hum_grade, title.windSpeed)
            todayCard.tdCoveragePer.text =
                itemView.context.getString(R.string.coverage_percent_td, title.cloudCover)
            todayCard.tdRainPer.text =
                itemView.context.getString(R.string.rain_mm_td, title.rainAmount)
            // todayCard.includLayout.hourlyItemToday= itemView.context.getString(R.string.td_hour, title.)
            //title.feelsLike, title.uvIndex, title.humidity, title.windSpeed, title.cloudCover, title.rainAmount)
        }
    }

    class TodayHourlyViewHolder(private val todayHourly: TodayHourlyItemBinding) :
        RecyclerView.ViewHolder(todayHourly.root) {
        fun bind(title: TodayDataClass.TodayHourlyClass) {
            todayHourly.td2Hour.text =
                itemView.context.getString(R.string.td2_hour, title.date.hour)
            todayHourly.td2Grade.text = itemView.context.getString(R.string.td2_grade, title.temp)
            todayHourly.td2HumidityPercent.text =
                itemView.context.getString(R.string.td2_humidity_percent, title.pericip)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> {
                TodayHeaderViewHolder(
                    TodayHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            CARD -> {
                TodayCardViewHolder(
                    TodayCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            HOURLY -> {
                TodayHourlyViewHolder(
                    TodayHourlyItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.forecast_item, parent, false)
                HomeScrAdapter.ForecastViewHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val currentItem = newList[position]) {
            is TodayDataClass.TodayHeaderClass -> {
                (holder as TodayHeaderViewHolder).bind(currentItem)
            }
            is TodayDataClass.TodayCardViewClass -> {
                (holder as TodayCardViewHolder).bind(currentItem)
            }
            is TodayDataClass.TodayHourlyClass -> {
                (holder as TodayHourlyViewHolder).bind(currentItem)
            }
            else -> {}
        }
    }

    override fun getItemCount(): Int = newList.size

    companion object {
        const val HEADER = 0
        const val CARD = 1
        const val HOURLY = 2

    }

}