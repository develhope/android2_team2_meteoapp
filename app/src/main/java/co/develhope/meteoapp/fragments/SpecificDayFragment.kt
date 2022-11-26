package co.develhope.meteoapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import co.develhope.meteoapp.adapters.SpecificDayAdapter

import co.develhope.meteoapp.data.SpecificDayForecastItems



import co.develhope.meteoapp.databinding.FragmentSpecificDayBinding


class SpecificDayFragment : Fragment() {
    private lateinit var binding: FragmentSpecificDayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?
        ,savedInstanceState: Bundle?): View {
            binding = FragmentSpecificDayBinding.inflate(inflater, container, false )
                return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        val recyclerView = binding.HourlyRecyclerView
        recyclerView.layoutManager = layoutManager
        //recyclerView.setHasFixedSize(true)
        val adapter = SpecificDayAdapter(SpecificDayForecastItems.getSpecificDayForecastItem())
        recyclerView.adapter = adapter
    }



    }