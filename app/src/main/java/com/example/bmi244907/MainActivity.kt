package com.example.bmi244907

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MESSAGE = "com.example.bmi244907.MESSAGE"

class MainActivity : AppCompatActivity() {

    private var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)

        val waga = findViewById<EditText>(R.id.editWaga)
        val wzrost = findViewById<EditText>(R.id.editWzrost)

        button?.setOnClickListener {
            var wartoscWagi = 0.0
            var wartoscWzrostu = 0.0
            if (waga.text.toString().isNotEmpty()) {
                wartoscWagi = waga.text.toString().toDouble()
            }
            if (wzrost.text.toString().isNotEmpty()) {
                wartoscWzrostu = wzrost.text.toString().toDouble()
            }
            if (wartoscWagi > 0.0 && wartoscWzrostu > 0.0) {
                val potega = wartoscWzrostu * wartoscWzrostu
                val bmi = wartoscWagi / potega
                val wartoscBMI = String.format("%.2f", bmi)
                val intent = Intent(this, MainActivity2::class.java).apply {
                    putExtra(EXTRA_MESSAGE, wartoscBMI)
                }
                startActivity(intent)
            } else
                Toast.makeText(
                    this, "Podaj wartość wagi i wzorstu powyżej 0",
                    Toast.LENGTH_LONG
                )
                    .show()
        }
    }
}
