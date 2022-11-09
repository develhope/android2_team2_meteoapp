package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.FragmentTransaction as FragmentTransaction1

class HomeFragment : Fragment() {

    private lateinit var adapter: HomeScrAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<SummaryForecast>

    lateinit var iconId: Array<Int>
    lateinit var tvDays: Array<String>
    lateinit var gradeMin: Array<String>
    lateinit var gradeMax: Array<String>
    lateinit var precipitation: Array<String>
    lateinit var wind: Array<String>
    lateinit var date: Array<String>
    lateinit var minTxt: Array<String>
    lateinit var maxTxt: Array<String>
    lateinit var windTxt: Array<String>
    lateinit var precipitationTxt: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val fragmentSpecificDayFragment= SpecificDayFragment()


        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.home_recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = HomeScrAdapter(newArrayList, listener =object :HomeScreenListener{
            override fun itemClick(item: SummaryForecast) {
                replaceFragment(fragmentSpecificDayFragment)
            }
        })

        recyclerView.adapter = adapter




    }
    private fun replaceFragment(specificDayFragment:  Fragment){

        val fragmentManager = activity?.supportFragmentManager

        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,specificDayFragment)

        fragmentTransaction.commit()

    }

    private fun dataInitialize(){

        newArrayList = arrayListOf()

        iconId = arrayOf(
            R.drawable.ic_sun,
            R.drawable.ic_sun_cloud,
            R.drawable.ic_sun,
            R.drawable.ic_raining,
            R.drawable.ic_sun
        )
        tvDays = arrayOf(
            getString(R.string.rc_tv_tomorrow),
            getString(R.string.rc_tv_monday),
            getString(R.string.rc_tv_tuesday),
            getString(R.string.rc_tv_wednesday),
            getString(R.string.rc_tv_thursday)
        )

        gradeMin = arrayOf(
            getString(R.string.rc_tv_grade_min_tom),
            getString(R.string.rc_tv_grade_min_mon),
            getString(R.string.rc_tv_grade_min_tue),
            getString(R.string.rc_tv_grade_min_wed),
            getString(R.string.rc_tv_grade_min_thu),
        )

        gradeMax = arrayOf(
            getString(R.string.rc_tv_grade_max_tom),
            getString(R.string.rc_tv_grade_max_mon),
            getString(R.string.rc_tv_grade_max_tue),
            getString(R.string.rc_tv_grade_max_wed),
            getString(R.string.rc_tv_grade_max_thu),
        )

        precipitation = arrayOf(
            getString(R.string.rc_tv_precip_num_tom),
            getString(R.string.rc_tv_precip_num_mon),
            getString(R.string.rc_tv_precip_num_tue),
            getString(R.string.rc_tv_precip_num_wed),
            getString(R.string.rc_tv_precip_num_thu)

        )

        wind = arrayOf(
            getString(R.string.rc_tv_kmh_tom),
            getString(R.string.rc_tv_kmh_mon),
            getString(R.string.rc_tv_kmh_tue),
            getString(R.string.rc_tv_kmh_wed),
            getString(R.string.rc_tv_kmh_thu)
        )

        date = arrayOf(
            getString(R.string.rc_tv_date_tom),
            getString(R.string.rc_tv_date_mon),
            getString(R.string.rc_tv_date_tue),
            getString(R.string.rc_tv_date_wed),
            getString(R.string.rc_tv_date_thu)
        )

        minTxt = arrayOf(
            getString(R.string.rc_tv_min_tom),
            getString(R.string.rc_tv_min_tom),
            getString(R.string.rc_tv_min_tom),
            getString(R.string.rc_tv_min_tom),
            getString(R.string.rc_tv_min_tom)
        )

        maxTxt = arrayOf(
            getString(R.string.rc_tv_max_tom),
            getString(R.string.rc_tv_max_tom),
            getString(R.string.rc_tv_max_tom),
            getString(R.string.rc_tv_max_tom),
            getString(R.string.rc_tv_max_tom)
        )

        windTxt = arrayOf(
            getString(R.string.rc_tv_wind_tom),
            getString(R.string.rc_tv_wind_tom),
            getString(R.string.rc_tv_wind_tom),
            getString(R.string.rc_tv_wind_tom),
            getString(R.string.rc_tv_wind_tom)
        )

        precipitationTxt = arrayOf(
            getString(R.string.rc_tv_precip_tom),
            getString(R.string.rc_tv_precip_tom),
            getString(R.string.rc_tv_precip_tom),
            getString(R.string.rc_tv_precip_tom),
            getString(R.string.rc_tv_precip_tom)
        )

        for (i in iconId.indices){
            val summaryForecast = SummaryForecast(gradeMin[i],gradeMax[i],precipitation[i], wind[i],iconId[i],
                tvDays[i],date[i],minTxt[i],maxTxt[i],windTxt[i],precipitationTxt[i])
            newArrayList.add(summaryForecast)
        }
    }


}