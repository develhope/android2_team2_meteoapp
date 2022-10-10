package co.develhope.meteoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeScrAdapter(private val newList: ArrayList<SummaryForecast>): RecyclerView.Adapter<HomeScrAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_list_item,parent,false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.icon.setImageResource(currentItem.icon)
        holder.tvDays.text = currentItem.days
        holder.gradeMin.text = currentItem.minTemp
        holder.gradeMax.text = currentItem.maxTemp
        holder.precipitation.text = currentItem.precipitation
        holder.wind.text = currentItem.wind
        holder.date.text = currentItem.date
        holder.minTxt.text = currentItem.minTxt
        holder.maxTxt.text = currentItem.maxTxt
        holder.windTxt.text = currentItem.windTxt
        holder.precipitationTxt.text = currentItem.precipitationTxt


    }

    override fun getItemCount(): Int {
        return newList.size
    }

    class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.palermo_sic)
        val subtitle: TextView = itemView.findViewById(R.id.tv_next_five)
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
        val precipitationTxt:TextView = itemView.findViewById(R.id.rc_tv_precipitation_text)

    }

    class
}