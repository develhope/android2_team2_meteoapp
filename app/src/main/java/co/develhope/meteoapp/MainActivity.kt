package co.develhope.meteoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.databinding.ActivityMainBinding
import co.develhope.meteoapp.fragments.HomeFragment
import co.develhope.meteoapp.fragments.SpecificDayFragment
import co.develhope.meteoapp.fragments.TomorrowFragment

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val todayFragment = SpecificDayFragment()
    private val tomorrowFragment = TomorrowFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        val bottomNav = binding.bottomNavigation
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_fragment -> replaceFragment(homeFragment)
                R.id.today_fragment -> replaceFragment(todayFragment)
                R.id.tomorrow_fragment -> replaceFragment(tomorrowFragment)
            }
            true
        }
    }

    private fun replaceFragment(homeFragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,homeFragment)
        fragmentTransaction.commit()
    }
}