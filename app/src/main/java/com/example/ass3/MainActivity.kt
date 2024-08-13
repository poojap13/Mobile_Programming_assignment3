package com.example.ass3

import android.content.Intent
import android.content.pm.PackageManager
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
            // Permission granted, show notification
            Toast.makeText(this, "Notification permission granted", Toast.LENGTH_SHORT).show()
        } else {
            // Permission denied, handle accordingly
            Toast.makeText(this, "Notification permission denied. Notifications will not be shown.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (shouldShowRequestPermissionRationale(android.Manifest.permission.POST_NOTIFICATIONS)) {
            // Show rationale and request permission
            notificationPermissionRequest.launch(android.Manifest.permission.POST_NOTIFICATIONS)
        } else {
            // Request permission directly
            notificationPermissionRequest.launch(android.Manifest.permission.POST_NOTIFICATIONS)
        }

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
