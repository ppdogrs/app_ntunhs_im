package com.example.hw5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeActivity = findViewById<Button>(R.id.btnChangeActivity)
        val btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)

        btnChangeActivity.setOnClickListener {
            var seconIntent = Intent(this,guess_numberActivity::class.java)
            startActivity(seconIntent)
        }

        btnOpenBrowser.setOnClickListener {
            var seconIntent = Intent(this,RPSActivity::class.java)
            startActivity(seconIntent)
        }
    }
}