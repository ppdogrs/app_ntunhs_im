package com.example.hw

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val id = findViewById<EditText>(R.id.inID)
        val name = findViewById<EditText>(R.id.inname)
        val pwd = findViewById<EditText>(R.id.inpwd)
        val birthdate = findViewById<EditText>(R.id.inbirthdate)
        val Gender = findViewById<RadioGroup>(R.id.genderRG)
        val M = findViewById<RadioButton>(R.id.male)
        val F = findViewById<RadioButton>(R.id.female)
        val Car = findViewById<CheckBox>(R.id.car)
        val Bike = findViewById<CheckBox>(R.id.bike)
        val Motorbike = findViewById<CheckBox>(R.id.motorbike)
        var gender = ""
        var msg = ""
        Gender.setOnCheckedChangeListener { _, checkedId ->
            gender = when(checkedId){
                R.id.female -> F.text.toString()
                R.id.male -> M.text.toString()
                else -> "I don't Know"
            }
        }
        val send_button = findViewById<Button>(R.id.send)
        send_button.setOnClickListener {
            msg = ""
            if (Car.isChecked){
                msg = msg + Car.getText().toString()
            }
            if (Bike.isChecked && Car.isChecked){
                msg = msg +"," + Bike.getText().toString()
            }else if (Bike.isChecked){
                msg = msg + Bike.getText().toString()
            }
            if (Motorbike.isChecked && Bike.isChecked){
                msg = msg +"," + Motorbike.getText().toString()
            }else if (Motorbike.isChecked && Car.isChecked){
                msg = msg +"," + Motorbike.getText().toString()
            }else if (Motorbike.isChecked){
                msg = msg + Motorbike.getText().toString()
            }
            AlertDialog.Builder(this,).setTitle("您填的訊息是")
                .setMessage("ID:" + id.text + '\n' + "pwd:" + pwd.text + '\n' + "Name:" + name.text + '\n' + "Birthdate:" + birthdate.text
                        + '\n' + "Gender: $gender" + '\n' + "Vehide: $msg")
                .create().show()

        }
        val applyDate = findViewById<EditText>(R.id.inbirthdate)
        applyDate.setOnClickListener {
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    var format = "${setDateFormat(year, month, day)}"
                    applyDate.setText(format)
                }
            }, year, month, day).show()
        }
    }
    private fun setDateFormat(year: Int, month: Int, day: Int): String{
        return "$year - ${month + 1} - $day"
    }
}