package com.example.theweatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailedViewScreenActivity : AppCompatActivity() {
    private lateinit var detailsTextView: TextView
    private lateinit var weatherConditionsTextviw3: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

        detailsTextView = findViewById(R.id.detailsTextView)
        weatherConditionsTextviw3 = findViewById(R.id.weatherConditionsTextView3)
        backButton = findViewById(R.id.backButton)

        val days = intent.getStringArrayListExtra("days") ?: arrayListOf()
        val minTemps = intent.getIntegerArrayListExtra("minTemps") ?: arrayListOf()
        val maxTemps = intent.getIntegerArrayListExtra("maxTemps") ?: arrayListOf()
        val weatherConditions = intent.getStringArrayListExtra("weatherConditions") ?: arrayListOf()

        val details = StringBuilder()
        var totalMinTemp = 0
        var totalMaxTemp = 0
        for (i in days.indices) {
            details.append("${days[i]}: Min Temp - ${minTemps[i]}°, Max Temp - ${maxTemps[i]}°, Condition - ${weatherConditions[i]}\n")
            totalMinTemp += minTemps[i]
            totalMaxTemp += maxTemps[i]
        }
        val averageMinTemp = if (days.isNotEmpty()) totalMinTemp / days.size else 0
        val averageMaxTemp = if (days.isNotEmpty()) totalMaxTemp / days.size else 0

        detailsTextView.text = details.toString()
        weatherConditionsTextviw3.text = "Average Min Temp: $averageMinTemp°, Average Max Temp: $averageMaxTemp°"

        backButton.setOnClickListener {
            finish()
        }
    }
}
