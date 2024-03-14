package com.example.text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val city = findViewById<Spinner>(R.id.city)
        val adapter = ArrayAdapter.createFromResource(this,R.array.city,android.R.layout.simple_spinner_dropdown_item)
        city.adapter = adapter

        city.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override  fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long){
                val citys = resources.getStringArray(R.array.city)
                if (pos>0)
                    Toast.makeText(this@MainActivity, "你選的是" + citys[pos], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        val numPicker = findViewById<NumberPicker>(R.id.numPicker_Age)
        numPicker.setMinValue(0)
        numPicker.setMaxValue(100)
        numPicker.setValue(50)

        val Grender = findViewById<RadioGroup>(R.id.Gender)
        val Male = findViewById<RadioButton>(R.id.M)
        val Female = findViewById<RadioButton>(R.id.F)
        Grender.setOnCheckedChangeListener { _, checkedid ->
            var gender = when (checkedid) {
                R.id.F -> Female.text.toString()
                R.id.M -> Male.text.toString()
                else -> "I don't Know"
            }
            Toast.makeText(this,gender+numPicker.getValue(), Toast.LENGTH_SHORT).show()
        }
        val ch1 = findViewById<CheckBox>(R.id.ch1)
        val ch2 = findViewById<CheckBox>(R.id.ch2)
        val ch3 = findViewById<CheckBox>(R.id.ch3)
        val btn_send = findViewById<Button>(R.id.btn_send)
        val b_test = findViewById<Button>(R.id.test)
        btn_send.setOnClickListener {
            var msg = ""
            if(ch1.isChecked()){
                msg = msg + ch1.getText().toString()
            }
            if(ch2.isChecked()){
                msg = msg + " , " + ch2.getText().toString()
            }
            if(ch3.isChecked()){
                msg = msg + " , " + ch3.getText().toString()
            }
            Toast.makeText(this@MainActivity, "你選的是" + msg, Toast.LENGTH_SHORT).show()
        }
        b_test.setOnClickListener {
            AlertDialog.Builder
        }
    }
}