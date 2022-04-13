package com.example.fitnessapp.ui.login.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.fitnessapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main_activity)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment).navController
        bottomNavView.setupWithNavController(navController)
    }
}