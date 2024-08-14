package com.example.ass3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MealSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_summary)

        val mealTypeTextView: TextView = findViewById(R.id.meal_type_text_view)
        val mealDateTextView: TextView = findViewById(R.id.meal_date_text_view)
        val mealTimeTextView: TextView = findViewById(R.id.meal_time_text_view)

        // Retrieve the meal details from the intent
        val mealType = intent.getStringExtra("MEAL_TYPE")
        val mealDate = intent.getStringExtra("MEAL_DATE")
        val mealTime = intent.getStringExtra("MEAL_TIME")

        // Display the meal details
        mealTypeTextView.text = "Meal: $mealType"
        mealDateTextView.text = "Date: $mealDate"
        mealTimeTextView.text = "Time: $mealTime"
    }
}
