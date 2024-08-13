package com.example.ass3

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val notificationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted
            Toast.makeText(this, "Notification permission granted", Toast.LENGTH_SHORT).show()
        } else {
            // Permission denied
            Toast.makeText(this, "Notification permission denied. Notifications will not be shown.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Request notification permission
        notificationPermissionRequest.launch(Manifest.permission.POST_NOTIFICATIONS)

        // Set up buttons and their click listeners
        val breakfastButton: Button = findViewById(R.id.btnBreakfast)
        val lunchButton: Button = findViewById(R.id.btnLunch)
        val dinnerButton: Button = findViewById(R.id.btnDinner)
        val brunchButton: Button = findViewById(R.id.btnBrunch)

        breakfastButton.setOnClickListener {
            startActivity(Intent(this, BreakfastActivity::class.java))
        }

        lunchButton.setOnClickListener {
            startActivity(Intent(this, LunchActivity::class.java))
        }

        dinnerButton.setOnClickListener {
            startActivity(Intent(this, DinnerActivity::class.java))
        }

        brunchButton.setOnClickListener {
            startActivity(Intent(this, BrunchActivity::class.java))
        }
    }
}
