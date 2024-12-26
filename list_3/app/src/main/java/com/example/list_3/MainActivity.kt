package com.example.list_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.list_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Integracja BottomNavigationView z NavController
        binding.bottomNavView.setupWithNavController(navController)

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ListaFragment -> {
                    navController.popBackStack(R.id.ListaFragment, false)
                    navController.navigate(R.id.ListaFragment)
                    true
                }
                R.id.ListyFragment -> {
                    navController.popBackStack(R.id.ListyFragment, false)
                    navController.navigate(R.id.ListyFragment)
                    true
                }
                else -> false
            }
        }

    }
}
