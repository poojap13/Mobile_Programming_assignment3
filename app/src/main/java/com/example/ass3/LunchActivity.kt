package com.example.ass3

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import java.util.*

class LunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)

        val mealSpinner: Spinner = findViewById(R.id.meal_spinner)
        val dateEditText: EditText = findViewById(R.id.date_edit_text)
        val timeEditText: EditText = findViewById(R.id.time_edit_text)
        val saveMealButton: Button = findViewById(R.id.btnSaveMeal)

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

        saveMealButton.setOnClickListener {
            val selectedMeal = mealSpinner.selectedItem.toString()
            val selectedDate = dateEditText.text.toString()
            val selectedTime = timeEditText.text.toString()

            // Send notification
            sendNotification(selectedMeal, selectedDate, selectedTime)

            // Start the MealSummaryActivity and pass the meal details
            val intent = Intent(this, MealSummaryActivity::class.java)
            intent.putExtra("MEAL_TYPE", selectedMeal)
            intent.putExtra("MEAL_DATE", selectedDate)
            intent.putExtra("MEAL_TIME", selectedTime)
            startActivity(intent)
        }
    }

    private fun sendNotification(meal: String, date: String, time: String) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "meal_planner_channel"
        val channelName = "Meal Planner Notifications"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Meal Planned")
            .setContentText("Your $meal meal is planned for $date at $time.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        notificationManager.notify(2, notificationBuilder.build())
    }
}
