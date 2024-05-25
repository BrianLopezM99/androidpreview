package com.brian.androidmastercurso.imcapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.brian.androidmastercurso.R
import com.brian.androidmastercurso.imcapp.ImcCalculatorActivity.Companion.IMC_KEY

class ResultImcActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imc)

        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponent()
        initUI(result)
        initListeners()

    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 -> {
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvResult.text = getString(R.string.title_bajo_peso)
                tvDescription.text = getString(R.string.descripcion_bajo_peso)

            }
            in 18.51..24.99 -> {
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvResult.text = getString(R.string.title_peso_normal)
                tvDescription.text = getString(R.string.descripcion_peso_normal)

            }
            in 25.00..99.99 -> {
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvResult.text = getString(R.string.title_sobrepeso)
                tvDescription.text = getString(R.string.descripcion_sobrepeso)
            }

            else -> {
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponent() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }


}