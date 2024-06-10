package com.example.theweatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class DetailedViewScreen {

}

class MainScreenActivity : AppCompatActivity() {

    private lateinit var dayEditText: EditText
    private lateinit var minEditText: EditText
    private lateinit var maxEditText: EditText
    private lateinit var weatherConditionEditText: EditText
    private val days = ArrayList<String>()
    private val min = ArrayList<Int>()
    private val max = ArrayList<Int>()
    private val weatherCondition = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)

        dayEditText = findViewById(R.id.dayEditText)
        minEditText = findViewById(R.id.minEditText)
        maxEditText = findViewById(R.id.maxEditText)
        weatherConditionEditText = findViewById(R.id.weatherConditionEditText)

        val addButton: Button = findViewById(R.id.addButton)
        val clearButton: Button = findViewById(R.id.clearButton)
        val detailedViewButton: Button = findViewById(R.id.detailedViewButton)

        addButton.setOnClickListener {
            addScreenTime()
        }

        clearButton.setOnClickListener {
            clearData()
        }

        detailedViewButton.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            intent.putStringArrayListExtra("days", days)
            intent.putIntegerArrayListExtra("min", min)
            intent.putIntegerArrayListExtra("max", max)
            intent.putStringArrayListExtra("weatherConditions", weatherCondition)
            startActivity(intent)
        }
    }

    class DetailedViewScreen {}



    private fun addScreenTime() {
        val day = dayEditText.text.toString()
        val weather = weatherConditionEditText.text.toString()
        val minTemp = minEditText.text.toString().toIntOrNull()
        val maxTemp = maxEditText.text.toString().toIntOrNull()

        if (day.isNotEmpty() && weather.isNotEmpty() && minTemp != null && maxTemp != null) {
            days.add(day)
            min.add(minTemp)
            max.add(maxTemp)
            weatherCondition.add(weather)

            dayEditText.text.clear()
            minEditText.text.clear()
            maxEditText.text.clear()
            weatherConditionEditText.text.clear()

            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearData() {
        days.clear()
        min.clear()
        max.clear()
        weatherCondition.clear()

        dayEditText.text.clear()
        minEditText.text.clear()
        maxEditText.text.clear()
        weatherConditionEditText.text.clear()

        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
    }
}