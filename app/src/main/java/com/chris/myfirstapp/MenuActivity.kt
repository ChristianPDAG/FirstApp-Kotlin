package com.chris.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.chris.myfirstapp.Todoapp.TodoActivity
import com.chris.myfirstapp.imccalculator.IMCAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<AppCompatButton>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<AppCompatButton>(R.id.btnIMCApp)
        val btnTODOApp = findViewById<AppCompatButton>(R.id.btnTODOApp)

        btnSaludApp.setOnClickListener{ navigateToSaludApp()  }
        btnIMCApp.setOnClickListener{ navigateToIMCApp()  }
        btnTODOApp.setOnClickListener { navigateToTODOApp() }

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


}