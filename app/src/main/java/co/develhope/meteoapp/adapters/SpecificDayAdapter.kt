package co.develhope.meteoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.ForecastScreenItem
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.TotalDataClass
import co.develhope.meteoapp.data.TotalDataClass.*
import co.develhope.meteoapp.databinding.DayHourlyItemBinding
import co.develhope.meteoapp.databinding.SpecificDayCardViewBinding
import co.develhope.meteoapp.databinding.SpecificDayTitleBinding

class SpecificDayAdapter(private val newList: List<TotalDataClass>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (newList[position]) {
            is TotalDataClass.SpecificDayCard -> SpecificDayAdapter.CARD
            is TotalDataClass.SpecificDayHourly -> SpecificDayAdapter.HOURLY
            is TotalDataClass.SpecificDayTitle1-> SpecificDayAdapter.TITLE
        }
    }


    class SpecificDayTitleViewHolder(private val specificDayTitle:SpecificDayTitleBinding): RecyclerView.ViewHolder(specificDayTitle.root){
      fun bind(title: SpecificDayTitle1){
           specificDayTitle.dayTitle.text=itemView.context.getString(R.string.specificDay_palermo_sic,title.region,title.city)
           //specificDayTitle.dayDescriptionTxt.text=itemView.context.getString(R.string.which_day_and_date,title.dayInfo)
          //should try the OffsetTimesolution for above problem
       }
    }
    class SpecificDayCardViewHolder(private val specificDayCard:SpecificDayCardViewBinding):RecyclerView.ViewHolder(specificDayCard.root){
        fun bind(title: SpecificDayCard){
            specificDayCard.tvDayPrecipitationGrade.text=itemView.context.getString(R.string.specificDay_precipitation_grade,title.feelsLike)
            //,title.windSpeed,title.humidity,title.uVIndex,title.cloudCover,title.rainAmount
       }
   }
    class SpecificDayHourlyViewHolder(private val specificDayHourly:DayHourlyItemBinding): RecyclerView.ViewHolder(specificDayHourly.root){
        fun bind(title: SpecificDayHourly){
            specificDayHourly.dayHour2.text=itemView.context.getString(R.string.specificDay_hour_second,title.date.hour)
           // specificDayHourly.dayIconMoon.setImageResource()
            //specificDayHourly.dayIconMoon
            specificDayHourly.dayGrade.text=itemView.context.getString(R.string.day_grade,title.temp)
            specificDayHourly.dayHumidityPercent.text=itemView.context.getString(R.string.specificDay_precipitation_grade,title.pericip)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TITLE -> {
                SpecificDayTitleViewHolder(
                    SpecificDayTitleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
          CARD-> {SpecificDayCardViewHolder(
              SpecificDayCardViewBinding.inflate(LayoutInflater.from(parent.context),parent,false) )
          }
          HOURLY-> {SpecificDayHourlyViewHolder(
               DayHourlyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

                   )}
           else -> {
                val itemView = LayoutInflater.from(parent.context)
                   .inflate(R.layout.forecast_item, parent, false)
               HomeScrAdapter.ForecastViewHolder(itemView)
           }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when (val currentItem = newList[position]) {
            is SpecificDayTitle1 -> {
                (holder as SpecificDayTitleViewHolder).bind(currentItem)
            }
            is SpecificDayCard -> {
               (holder as SpecificDayCardViewHolder).bind(currentItem)
            }
            is SpecificDayHourly -> {
              (holder as SpecificDayHourlyViewHolder).bind(currentItem)
           }
            else -> {}
       }
    }


   override fun getItemCount(): Int = newList.size
    companion object objects {

        const val TITLE= 0

        const val CARD= 1

        const val HOURLY = 2
    }


}