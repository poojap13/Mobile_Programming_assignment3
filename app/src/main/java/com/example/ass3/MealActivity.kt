package com.example.ass3

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

abstract class MealActivity : AppCompatActivity() {

    private lateinit var dateEditText: EditText
    private lateinit var timeEditText: EditText
    private lateinit var mealSpinner: Spinner
    private lateinit var saveButton: Button
    private var mealType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        mealType = intent.getStringExtra("MEAL_TYPE")

        dateEditText = findViewById(R.id.date_edit_text)
        timeEditText = findViewById(R.id.time_edit_text)
        mealSpinner = findViewById(R.id.meal_spinner)
        saveButton = findViewById(R.id.btnSaveMeal)

        // Date picker
        dateEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    dateEditText.setText("${selectedDay}/${selectedMonth + 1}/${selectedYear}")
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        // Time picker
        timeEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this,
                { _, selectedHour, selectedMinute ->
                    timeEditText.setText(String.format("%02d:%02d", selectedHour, selectedMinute))
                },
                hour, minute, true
            )
            timePickerDialog.show()
        }

        // Save button
        saveButton.setOnClickListener {
            val meal = mealSpinner.selectedItem.toString()
            val date = dateEditText.text.toString()
            val time = timeEditText.text.toString()

            if (meal.isNotEmpty() && date.isNotEmpty() && time.isNotEmpty()) {
                // Create intent to pass data
                val intent = Intent(this, MealNotificationActivity::class.java).apply {
                    putExtra("MEAL_TYPE", mealType)
                    putExtra("MEAL_NAME", meal)
                    putExtra("DATE", date)
                    putExtra("TIME", time)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Abstract method to get layout id
    abstract fun getLayoutId(): Int
}
