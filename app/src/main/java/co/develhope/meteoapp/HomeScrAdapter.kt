package co.develhope.meteoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeScrAdapter(private val newList: List<ForecastScreenItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_list_item, parent, false)
                CardViewHolder(itemView)
            }
            SUBTITLE -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_list_item, parent, false)
                SubTitleViewHolder(itemView)
            }

            TITLE -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_list_item, parent, false)
                TitleViewHolder(itemView)
            }

            else -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_list_item, parent, false)
                CardViewHolder(itemView)
            }
        }


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val currentItem = newList[position]) {
            is ForecastScreenItem.Forecast -> {
                (holder as CardViewHolder).bind(currentItem)
            }
            is ForecastScreenItem.Subtitle -> TODO()
            is ForecastScreenItem.Title -> TODO()
        }

    }

    override fun getItemCount(): Int {
        return newList.size
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(currentItem: ForecastScreenItem.Forecast) {
            val icon: ImageView = itemView.findViewById(R.id.rc_cloudy)
            val tvDays: TextView = itemView.findViewById(R.id.rc_tv_today)
            val gradeMin: TextView = itemView.findViewById(R.id.rc_tv_grade_min)
            val gradeMax: TextView = itemView.findViewById(R.id.rc_tv_grade_max)
            val precipitation: TextView = itemView.findViewById(R.id.rc_tv_precipitation)
            val wind: TextView = itemView.findViewById(R.id.rc_tv_speed)
            val date: TextView = itemView.findViewById(R.id.rc_tv_date)
            val minTxt: TextView = itemView.findViewById(R.id.rc_tv_min)
            val maxTxt: TextView = itemView.findViewById(R.id.rc_tv_max)
            val windTxt: TextView = itemView.findViewById(R.id.rc_tv_wind)
            val precipitationTxt: TextView = itemView.findViewById(R.id.rc_tv_precipitation_text)

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
        val icon: ImageView = itemView.findViewById(R.id.rc_cloudy)
        val tvDays: TextView = itemView.findViewById(R.id.rc_tv_today)
        val gradeMin: TextView = itemView.findViewById(R.id.rc_tv_grade_min)
        val gradeMax: TextView = itemView.findViewById(R.id.rc_tv_grade_max)
        val precipitation: TextView = itemView.findViewById(R.id.rc_tv_precipitation)
        val wind: TextView = itemView.findViewById(R.id.rc_tv_speed)
        val date: TextView = itemView.findViewById(R.id.rc_tv_date)
        val minTxt: TextView = itemView.findViewById(R.id.rc_tv_min)
        val maxTxt: TextView = itemView.findViewById(R.id.rc_tv_max)
        val windTxt: TextView = itemView.findViewById(R.id.rc_tv_wind)
        val precipitationTxt: TextView = itemView.findViewById(R.id.rc_tv_precipitation_text)

    }

    class SubTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.rc_cloudy)
        val tvDays: TextView = itemView.findViewById(R.id.rc_tv_today)
        val gradeMin: TextView = itemView.findViewById(R.id.rc_tv_grade_min)
        val gradeMax: TextView = itemView.findViewById(R.id.rc_tv_grade_max)
        val precipitation: TextView = itemView.findViewById(R.id.rc_tv_precipitation)
        val wind: TextView = itemView.findViewById(R.id.rc_tv_speed)
        val date: TextView = itemView.findViewById(R.id.rc_tv_date)
        val minTxt: TextView = itemView.findViewById(R.id.rc_tv_min)
        val maxTxt: TextView = itemView.findViewById(R.id.rc_tv_max)
        val windTxt: TextView = itemView.findViewById(R.id.rc_tv_wind)
        val precipitationTxt: TextView = itemView.findViewById(R.id.rc_tv_precipitation_text)

    }

    companion object {
        const val TITLE = 0
        const val CARD = 1
        const val SUBTITLE = 2
    }


}