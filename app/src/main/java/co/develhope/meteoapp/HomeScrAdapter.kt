package co.develhope.meteoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeScrAdapter(private val frameList: ArrayList<SummaryForecast>): RecyclerView.Adapter<HomeScrAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = frameList[position]
        holder.icon.setImageResource(currentItem.icon)
        holder.tvDays.text = currentItem.days
        holder.gradeMin.text = currentItem.minTemp.toString()
        holder.gradeMax.text = currentItem.maxTemp.toString()
        holder.precipitation.text = currentItem.precipitation.toString()
        holder.wind.text = currentItem.wind.toString()
        holder.date.text = currentItem.date.toString()
        holder.minTxt.text = currentItem.minTxt
        holder.maxTxt.text = currentItem.maxTxt
        holder.windTxt.text = currentItem.windTxt
        holder.precipitationTxt.text = currentItem.precipitationTxt

    }

    override fun getItemCount(): Int {
        return frameList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
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
}