package com.example.hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val back = findViewById<Button>(R.id.back)
        val txttest = findViewById<TextView>(R.id.txttest)
        val text = intent.getBundleExtra("key")?.getString("name")

        txttest.setText(text)

        back.setOnClickListener {
            finish()
        }

        }
    var lastTime: Long = 0
    override fun finish(){
        val currentTime = System.currentTimeMillis()
        if(currentTime - lastTime > 3 * 1000){
            lastTime = currentTime
            Toast.makeText(this,"在案一次離開",Toast.LENGTH_SHORT).show()
        }else  {
            super.finish()
        }
    }
}