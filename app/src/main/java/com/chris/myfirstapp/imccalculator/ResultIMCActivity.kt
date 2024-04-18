package com.chris.myfirstapp.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chris.myfirstapp.R
import com.chris.myfirstapp.imccalculator.IMCAppActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
    }
}