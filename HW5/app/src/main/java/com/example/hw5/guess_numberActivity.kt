package com.example.hw5

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class guess_numberActivity : AppCompatActivity() {
    val TAG:String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_number)
        handler = Handler(Looper.getMainLooper())

        val mainView = findViewById<TextView>(R.id.mainView)
        val ANS = findViewById<TextView>(R.id.ANS)
        val inView = findViewById<EditText>(R.id.inView)
        val guess = findViewById<Button>(R.id.guess)
        val reset = findViewById<Button>(R.id.reset)
        val back = findViewById<Button>(R.id.back_guess)
        var Vnumber:Int
        var secr : Int = Random.nextInt(100) + 1
        var max:Int = 100
        var min:Int = 1
        mainView.text = "please enter number"
        guess.setOnClickListener {
            /*Toast.makeText(this, inView.text,Toast.LENGTH_SHORT).show()
            AlertDialog.Builder(this).setTitle("onclick").setMessage("onclick").create().show()*/
            /*mainView.text = inView.text*/
            /*Vnumber = inView.text.toString().toInt()-secr*/
            var ans:String ="win"
            if(inView.text.toString().toInt() > secr){
                max = inView.text.toString().toInt()
            }else if(inView.text.toString().toInt() < secr){
                min = inView.text.toString().toInt()
            }
            mainView.text = min.toString() + "-" + max.toString()

            if(inView.text.toString().toInt() == secr){
                ANS.text = ans
                handler.postDelayed({
                    Toast.makeText(this,"已重製",Toast.LENGTH_SHORT).show()
                    mainView.text = "please enter number"
                    ANS.text = ""
                    max = 100
                    min = 1
                },6000)

            }



        }
        /*ANS.text = secr.toString()*/
        reset.setOnClickListener{
            secr = Random.nextInt(100) + 1
            mainView.text = "please enter number"
            /*ANS.text = secr.toString()*/
            ANS.text = ""
            max = 100
            min = 1
        }
        back.setOnClickListener {
            finish()
        }

    }
    override fun  onDestroy(){
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
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