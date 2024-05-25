package com.brian.androidmastercurso.imcapp

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.brian.androidmastercurso.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 60
    private var currentAge:Int = 18
    private var currentHeight:Int = 120

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView

    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider

    private lateinit var btnSubstractWeight:FloatingActionButton
    private lateinit var btnPlusWeight:FloatingActionButton
    private lateinit var btnPlusAge:FloatingActionButton
    private lateinit var btnSubstractAge:FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var tvAge:TextView
    private lateinit var btnCalculate:Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        initComponent()
        initListeners()
        initUI()

    }

    private fun initComponent(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeihgt)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)
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
        
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }

        btnPlusWeight.setOnClickListener{
            currentWeight +=1
            setWeight()
        }
        btnSubstractWeight.setOnClickListener{
            currentWeight -=1
            setWeight()
        }

        btnSubstractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnCalculate.setOnClickListener{
            val result = calculateIMC()
            navigateToResult(result)
        }

    }

    private fun navigateToResult(result:Double) {
        val intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight/(currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        val result = df.format(imc).toDouble()
        Log.i("biandev", "El imc es $result")

        return result
    }

    private fun setAge() {
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

    private fun getBackgroundColor(isSelectedComponent:Boolean): Int{

        val colorReference = if(isSelectedComponent){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setWeight()
        setGenderColor()
        setAge()
    }
}