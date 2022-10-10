package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    //TODO we don't need this global variables
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

    private val newList = ArrayList<ForecastScreenItem>()

    //TODO this function should be in an object{}, because we need to divide things  fo the future (aka when network calls will be implemented)
    //TODO Instead of populate a global list object, why don't return directly the list of ForecastScreenItem?
    private fun createList() {
        newList.add(ForecastScreenItem.Title("Palermo, Sicilia"))
        newList.add(
            ForecastScreenItem.Forecast(
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
        newList.add(ForecastScreenItem.Subtitle("Next 5 days"))
        newList.add(
            ForecastScreenItem.Forecast(
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
            ForecastScreenItem.Forecast(
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
            ForecastScreenItem.Forecast(
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
            ForecastScreenItem.Forecast(
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
            ForecastScreenItem.Forecast(
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