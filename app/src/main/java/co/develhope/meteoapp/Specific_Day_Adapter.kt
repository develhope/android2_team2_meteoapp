package co.develhope.meteoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.Shapeable

class Specific_Day_Adapter(private val dataList: ArrayList<AllDatas>
):
    RecyclerView.Adapter<Specific_Day_Adapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.example_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
         holder.iconSunny.setImageResource(currentItem.sunImage)
       // holder.iconDrop.setImageResource(currentItem.d)
        holder.hour.text = currentItem.hour
        holder.temp.text = currentItem.temprature.toString()
        holder.humidity.text = currentItem.humidity.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val hour: TextView = itemView.findViewById(R.id.hour)
        val temp: TextView = itemView.findViewById(R.id.temp2)
        val iconSunny: ImageView = itemView.findViewById(R.id.sunny)
        val humidity: TextView = itemView.findViewById(R.id.humidity_degree)
        val iconDrop: ImageView = itemView.findViewById(R.id.dropIcon)

    }

}