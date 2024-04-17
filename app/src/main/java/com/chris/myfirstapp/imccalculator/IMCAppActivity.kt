package com.chris.myfirstapp.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.chris.myfirstapp.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCAppActivity : AppCompatActivity() {
    private var isMaleSelected = true
    private var isFemaleSelected = false

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider

    //se pone arriba la declaración del componente y se declara en los metodos.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcapp)
        initComponents()
        initListeners()
        initUI()

    }
    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
    }
    private fun initListeners(){
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener{ _ , value, _ ->
            val df = DecimalFormat("#.##") //df = decimal format, formatear decimal para quitar el decimal
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
    }
    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }
    private fun getBackgroundColor(isSelectedComponent:Boolean) : Int{

        val colorReference = if(isSelectedComponent){
            R.color.backgroung_component_selected
        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this,colorReference)
    }
    private fun initUI(){
        setGenderColor()
    }
}