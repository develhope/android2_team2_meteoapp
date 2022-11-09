package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class SpecificDayFragment : Fragment() {
    private lateinit var adapter: Specific_Day_Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<AllDatas>

    lateinit var icons: Array<Int>
    lateinit var hours: Array<String>
    lateinit var temprature: Array<String>
    lateinit var humidity: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_specific_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.Specific_day_recycler_view)
        recyclerView.layoutManager = layoutManager

        dataInitialize()

        recyclerView.adapter = Specific_Day_Adapter(newArrayList)
    }

    private fun dataInitialize() {
        newArrayList = arrayListOf()
        icons = arrayOf(
            R.drawable.ic_sun,
            R.drawable.ic_sun_cloud,
            R.drawable.ic_sun,
            R.drawable.ic_raining,
            R.drawable.ic_sun,
            R.drawable.ic_fluent_moon
        )
        hours = arrayOf("00:00", "01:00", "02:00", "03:00", "04:00", "05:00")
        temprature = arrayOf("35°", "40°", "34°", "31°", "30°", "38°")
        humidity = arrayOf("55%", "40%", "30%", "35%", "50%", "45%")
        for (i in hours.indices) {
            val arr = AllDatas(hours[i], temprature[i], humidity[i],icons[i])
            newArrayList.add(arr)
        }


    }
}