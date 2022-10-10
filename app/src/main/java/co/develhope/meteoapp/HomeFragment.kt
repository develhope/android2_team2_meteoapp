package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var adapter: HomeScrAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<SummaryForecast>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createList()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.home_recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = HomeScrAdapter(newArrayList)
        recyclerView.adapter = adapter
    }

    val list = ArrayList<SummaryForecast>()

    private val newList = ArrayList<ForecastScreenItems>()

    private fun createList() {
        newList.add(ForecastScreenItems.Title("Palermo, Sicilia"))
        newList.add(
            ForecastScreenItems.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        newList.add(ForecastScreenItems.Subtitle("Next 5 days"))
        newList.add(
            ForecastScreenItems.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        newList.add(
            ForecastScreenItems.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        newList.add(
            ForecastScreenItems.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        newList.add(
            ForecastScreenItems.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )
        newList.add(
            ForecastScreenItems.Forecast(
                SummaryForecast(
                    minTemp = "",
                    maxTemp = "",
                    precipitation = "",
                    wind = "",
                    icon = 0,
                    days = "",
                    date = "",
                    minTxt = "",
                    maxTxt = "",
                    windTxt = "",
                    precipitationTxt = ""
                )
            )
        )

    }
}