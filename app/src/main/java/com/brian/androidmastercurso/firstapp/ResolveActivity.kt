package com.brian.androidmastercurso.firstapp

import android.os.Bundle
import android.text.Editable
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.brian.androidmastercurso.R

class ResolveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resolve)
        val tvResolve = findViewById<TextView>(R.id.tvResolve)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        tvResolve.text = "Hola $name"

    }
}