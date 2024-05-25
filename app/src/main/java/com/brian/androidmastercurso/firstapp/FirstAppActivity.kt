package com.brian.androidmastercurso.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.brian.androidmastercurso.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val etName = findViewById<AppCompatEditText>(R.id.etName)



        btnStart.setOnClickListener{
            val name = etName.text.toString()

            if (name.isNotEmpty()){
                Log.i("BrianTagxd", "Boton pulsado bb")
                val intent = Intent(this, ResolveActivity::class.java )
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }

        }
    }
}