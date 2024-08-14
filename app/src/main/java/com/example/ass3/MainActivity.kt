package com.example.ass3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Request notification permission (if needed)
        // notificationPermissionRequest.launch(Manifest.permission.POST_NOTIFICATIONS)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                startActivity(Intent(this, ProfileActivity::class.java))
                true
            }
            R.id.action_past_meals -> {
                startActivity(Intent(this, PastMealsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
