package com.example.lista_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.lista_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding  // Deklarujemy zmienną o odpowiednim typie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Używamy DataBindingUtil z odpowiednim typem ActivityMainBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Inicjalizacja NavHostFragment i NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Tworzymy konfigurację AppBar, aby wiedzieć, kiedy pokazać przycisk "Up" (wstecz)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.studentListFragment) // Główna strona nie będzie miała przycisku wstecz
        )

        // Konfiguracja ActionBar z NavController
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    // Obsługa przycisku "Up" (wstecz)
    override fun onSupportNavigateUp(): Boolean {
        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
