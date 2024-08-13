package com.example.ass3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MealNotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_notification) // Ensure this layout exists or create it

        val mealType = intent.getStringExtra("MEAL_TYPE") ?: ""
        val mealName = intent.getStringExtra("MEAL_NAME") ?: ""
        val date = intent.getStringExtra("DATE") ?: ""
        val time = intent.getStringExtra("TIME") ?: ""

        // Initialize NotificationHelper
        val notificationHelper = NotificationHelperActivity(this)
        notificationHelper.sendNotification(mealType, mealName, time, date)
    }
}
