package com.chris.myfirstapp.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.chris.myfirstapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCAppActivity : AppCompatActivity() {
    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 60
    private var currentAge:Int = 15
    private var currentHeight:Int = 120

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight:FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var btnSubtratAge:FloatingActionButton
    private lateinit var btnPlusAge:FloatingActionButton
    private lateinit var tvAge:TextView
    private lateinit var btnCalculate:Button

    companion object {
        //atributo global
        const val IMC_KEY = "IMC_RESULT"
    }


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
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnSubtratAge = findViewById(R.id.btnSubtractAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)

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
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnPlusWeight.setOnClickListener {
            currentWeight +=1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -=1
            setWeight()
        }

        btnPlusAge.setOnClickListener {
            currentAge +=1
            setAge()
        }
        btnSubtratAge.setOnClickListener {
            currentAge -=1
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }
    private fun navigateToResult(result:Double){
        val intent = Intent(this,ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }
    private fun calculateIMC():Double{
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()

    }
    private fun setAge(){
        tvAge.text = currentAge.toString()
    }
    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
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
        setWeight()
        setAge()
    }
}