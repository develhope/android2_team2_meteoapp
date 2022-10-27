package co.develhope.meteoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.ForecastScreenItem
import co.develhope.meteoapp.R

class HomeScrAdapter(private val newList: List<ForecastScreenItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (newList[position]) {
            is ForecastScreenItem.Forecast -> CARD
            is ForecastScreenItem.Subtitle -> SUBTITLE
            is ForecastScreenItem.Title -> TITLE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CARD -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.forecast_item, parent, false)
                ForecastViewHolder(itemView)
            }
            SUBTITLE -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.subtitle_item, parent, false)
                SubTitleViewHolder(itemView)
            }

            TITLE -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.title_item, parent, false)
                TitleViewHolder(itemView)
            }

            else -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.forecast_item, parent, false)
                ForecastViewHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val currentItem = newList[position]) {
            is ForecastScreenItem.Forecast -> {
                (holder as ForecastViewHolder).bind(currentItem)
            }
            is ForecastScreenItem.Subtitle -> {
                (holder as SubTitleViewHolder).bind(currentItem)
            }
            is ForecastScreenItem.Title -> {
                (holder as TitleViewHolder).bind(currentItem)
            }
        }

    }

    override fun getItemCount(): Int = newList.size

    class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(currentItem: ForecastScreenItem.Forecast) {
            val icon: ImageView = itemView.findViewById(R.id.ic_cloudy)
            val tvDays: TextView = itemView.findViewById(R.id.tv_today)
            val gradeMin: TextView = itemView.findViewById(R.id.tv_grade_min)
            val gradeMax: TextView = itemView.findViewById(R.id.tv_grade_max)
            val precipitation: TextView = itemView.findViewById(R.id.tv_precipitation)
            val wind: TextView = itemView.findViewById(R.id.tv_wind)
            val date: TextView = itemView.findViewById(R.id.tv_date)
            val minTxt: TextView = itemView.findViewById(R.id.tv_min)
            val maxTxt: TextView = itemView.findViewById(R.id.tv_max)
            val windTxt: TextView = itemView.findViewById(R.id.tv_speed)
            val precipitationTxt: TextView = itemView.findViewById(R.id.tv_precipitation_text)

            icon.setImageResource(currentItem.summaryForecast.icon)
            tvDays.text = currentItem.summaryForecast.days
            gradeMin.text = currentItem.summaryForecast.minTemp
            gradeMax.text = currentItem.summaryForecast.maxTemp
            precipitation.text = currentItem.summaryForecast.precipitation
            wind.text = currentItem.summaryForecast.wind
            date.text = currentItem.summaryForecast.date
            minTxt.text = currentItem.summaryForecast.minTxt
            maxTxt.text = currentItem.summaryForecast.maxTxt
            windTxt.text = currentItem.summaryForecast.windTxt
            precipitationTxt.text = currentItem.summaryForecast.precipitationTxt
        }
    }

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(currentItem: ForecastScreenItem.Title) {
            val title: TextView = itemView.findViewById(R.id.title_tv)
            title.text = currentItem.title
        }
    }

    class SubTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(currentItem: ForecastScreenItem.Subtitle) {
            val subtitle: TextView = itemView.findViewById(R.id.tv_subtitle)
            subtitle.text = currentItem.subTitle
        }

    }

    companion object {
        const val TITLE = 0
        const val CARD = 1
        const val SUBTITLE = 2
    }
}