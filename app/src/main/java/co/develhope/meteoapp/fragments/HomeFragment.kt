package co.develhope.meteoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.adapters.HomeScrAdapter
import co.develhope.meteoapp.data.ForecastModel
import co.develhope.meteoapp.data.weekly.ForecastScreenItem
import co.develhope.meteoapp.data.weekly.WeeklyCard
import co.develhope.meteoapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initRecyclerView(itemsList: List<WeeklyCard>) {

        itemsList.sortedBy { it.date }
        val screenItem: List<ForecastScreenItem> = screenUI(itemsList.toMutableList())
        val homeScrAdapter = HomeScrAdapter(screenItem)
        binding.homeRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            adapter = homeScrAdapter
        }
    }

    private fun screenUI(itemsList: MutableList<WeeklyCard>): List<ForecastScreenItem> {
        val homeList = arrayListOf<ForecastScreenItem>()
        homeList.add(ForecastScreenItem.Title("Marino", "Roma"))
        homeList.add(ForecastScreenItem.Forecast(itemsList.first()))
        homeList.add(ForecastScreenItem.Subtitle("Next 5 Days"))
        itemsList.removeFirst()
        itemsList.removeLast()
        homeList.addAll(
            itemsList.map {
                ForecastScreenItem.Forecast(it)
            }
        )
        return homeList
    }
}