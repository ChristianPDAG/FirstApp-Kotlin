package com.chris.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.chris.myfirstapp.Todoapp.TodoActivity
import com.chris.myfirstapp.databinding.ActivityMenuBinding
import com.chris.myfirstapp.imccalculator.IMCAppActivity
import com.chris.myfirstapp.settings.SettingsActivity
import com.chris.myfirstapp.superheroapp.SuperHeroListActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaludApp.setOnClickListener{ navigateToSaludApp()  }
        binding.btnIMCApp.setOnClickListener{ navigateToIMCApp()  }
        binding.btnTODOApp.setOnClickListener { navigateToTODOApp() }
        binding.btnSuperhero.setOnClickListener { navigateToSuperheroApp() }
        binding.btnSettings.setOnClickListener { navigateToSettings() }

    }

    private fun navigateToSuperheroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODOApp(){
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToIMCApp(){
        val intent = Intent(this, IMCAppActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToSaludApp(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSettings(){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }


}