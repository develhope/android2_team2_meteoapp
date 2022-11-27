package co.develhope.meteoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.adapters.SpecificDayAdapter
import co.develhope.meteoapp.data.ForecastModel
import co.develhope.meteoapp.data.dataModel.DailyForecast
import co.develhope.meteoapp.data.dataModel.DailyScreenItems
import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding
import org.threeten.bp.OffsetDateTime


class SpecificDayFragment : Fragment() {
    private lateinit var binding: FragmentSpecificDayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSpecificDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(ForecastModel.getDailyWeatherList())
    }

    private fun initRecyclerView(hourlyForecastList: List<DailyForecast>) {

        val itemToShow: List<DailyScreenItems> = screenUI(hourlyForecastList.toMutableList())
        val specificDayAdapter = SpecificDayAdapter(itemToShow)

        binding.HourlyRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            adapter = specificDayAdapter
        }
    }

    private fun screenUI(hourlyForecastList: MutableList<DailyForecast>): List<DailyScreenItems> {
        val specificScreen = arrayListOf<DailyScreenItems>()
        specificScreen.add(
            DailyScreenItems.Title(OffsetDateTime.now(), "Marino", "Roma"))
        specificScreen.addAll(
            hourlyForecastList.map { DailyScreenItems.HourlyForecast(it) }
        )
        return specificScreen
    }
}