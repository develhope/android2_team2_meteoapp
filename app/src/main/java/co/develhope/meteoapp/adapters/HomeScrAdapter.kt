package co.develhope.meteoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.ForecastModel
import co.develhope.meteoapp.data.weekly.ForecastScreenItem
import co.develhope.meteoapp.databinding.ForecastItemBinding
import co.develhope.meteoapp.databinding.SubtitleItemBinding
import co.develhope.meteoapp.databinding.TitleItemBinding

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
            TITLE -> TitleViewHolder(
                TitleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )
            CARD -> ForecastViewHolder(
                ForecastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            SUBTITLE -> SubTitleViewHolder(
                SubtitleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw java.lang.IllegalArgumentException("Invalid View Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> holder.bind(newList[position] as ForecastScreenItem.Title)
            is ForecastViewHolder -> holder.bind(newList[position] as ForecastScreenItem.Forecast)
            is SubTitleViewHolder -> holder.bind(newList[position] as ForecastScreenItem.Subtitle)
        }
    }

    override fun getItemCount(): Int = newList.size

    class ForecastViewHolder(private val binding: ForecastItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(forecastItem: ForecastScreenItem.Forecast) {

            binding.tvDate.text = itemView.context.getString(R.string.tv_date,
                forecastItem.weeklyCard.date.dayOfMonth,
                forecastItem.weeklyCard.date.monthValue)
            binding.tvGradeMax.text = itemView.context.getString(R.string.tv_grade_max,
                forecastItem.weeklyCard.maxTemp)
            binding.tvGradeMin.text = itemView.context.getString(R.string.tv_grade_min,
                forecastItem.weeklyCard.minTemp)
            binding.tvPrecipitation.text = itemView.context.getString(R.string.tv_precip_num,
                forecastItem.weeklyCard.precipitation)
            binding.tvSpeed.text = itemView.context.getString(R.string.tv_kmh,
                forecastItem.weeklyCard.wind)
            binding.tvToday.text = ForecastModel.setDayOfWeek(forecastItem.weeklyCard.date.dayOfWeek.name)
            binding.icCloudy.setImageResource(ForecastModel.setIcon(forecastItem.weeklyCard.weather))

        }
    }

    class TitleViewHolder(private val binding: TitleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(titleItem: ForecastScreenItem.Title) {
            binding.titleTv.text = itemView.context.getString(
                R.string.palermo_sic,
                titleItem.city,
                titleItem.region
            )
        }
    }

    class SubTitleViewHolder(private val binding: SubtitleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(subtitleItem: ForecastScreenItem.Subtitle) {
            binding.tvSubtitle.text = itemView.context.getString(
                R.string.next_five_days,
                subtitleItem.subTitle
            )
        }
    }

    companion object {
        const val TITLE = 0
        const val CARD = 1
        const val SUBTITLE = 2
    }
}