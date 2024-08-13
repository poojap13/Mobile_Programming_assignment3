package com.example.ass3

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class YourActivity : AppCompatActivity() {

    private val NOTIFICATION_PERMISSION_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_activity)

        val saveButton: Button = findViewById(R.id.btnSaveMeal)

        saveButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {

                // Request notification permission
                ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    NOTIFICATION_PERMISSION_CODE)
            } else {
                // Permission already granted, proceed with saving meal and showing notification
                saveMealAndShowNotification()
            }
        }
    }

    private fun saveMealAndShowNotification() {
        // Your code to save the meal and show notification
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == NOTIFICATION_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with saving meal and showing notification
                saveMealAndShowNotification()
            } else {
                // Permission denied, handle accordingly
                Toast.makeText(this, "Notification permission denied. Notifications will not be shown.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
