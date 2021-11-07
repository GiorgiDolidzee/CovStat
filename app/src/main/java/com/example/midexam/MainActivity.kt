package com.example.midexam

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        navView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfig = AppBarConfiguration(setOf(
            R.id.homeFragment, R.id.recommendationFragment, R.id.settingFragment
        ))

        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)
        hideToolBar()
    }

    fun showToolBar() {
        navView.visibility = View.VISIBLE
    }

    fun hideToolBar() {
        navView.visibility = View.GONE
    }

}