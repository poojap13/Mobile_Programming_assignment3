package com.example.ass3

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
class LunchActivity : AppCompatActivity() {

    private lateinit var notificationHelper: NotificationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)

        notificationHelper = NotificationHelper(this)

        val dateEditText: EditText = findViewById(R.id.date_edit_text)
        val timeEditText: EditText = findViewById(R.id.time_edit_text)
        val saveButton: Button = findViewById(R.id.btnSaveMeal)

        saveButton.setOnClickListener {
            val mealType = "Lunch" // This could be dynamically set based on user input
            val dateTime = "${dateEditText.text} at ${timeEditText.text}"

            // Correct method call
            notificationHelper.showNotification(mealType, dateTime)
        }
    }
}
