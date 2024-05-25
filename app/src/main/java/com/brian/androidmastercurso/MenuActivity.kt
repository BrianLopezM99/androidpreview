package com.brian.androidmastercurso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.brian.androidmastercurso.firstapp.FirstAppActivity
import com.brian.androidmastercurso.imcapp.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnMenu1 = findViewById<Button>(R.id.btnMenu1)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)

        btnMenu1.setOnClickListener{navigateToSaludApp()}
        btnIMCApp.setOnClickListener{navigateToIMCApp()}

    }

    fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    fun navigateToIMCApp(){
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }
}