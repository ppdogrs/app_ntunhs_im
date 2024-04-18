package com.example.guess_number

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guess_number.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val TAG:String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler
    private lateinit var binding: ActivityMainBinding
    private val game = guess_game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        handler = Handler(Looper.getMainLooper())
        //val mainView = findViewById<TextView>(R.id.mainView)
        //val ANS = findViewById<TextView>(R.id.ANS)
        //val inView = findViewById<EditText>(R.id.inView)
        //val guess = findViewById<Button>(R.id.guess)
        //val reset = findViewById<Button>(R.id.reset)
        binding.mainView.text = "please enter number"
        binding.guess.setOnClickListener {
            /*Toast.makeText(this, inView.text,Toast.LENGTH_SHORT).show()
            AlertDialog.Builder(this).setTitle("onclick").setMessage("onclick").create().show()*/
            /*mainView.text = inView.text*/
            /*Vnumber = inView.text.toString().toInt()-secr*/
            var ans:String ="win"
            if(binding.inView.text.toString() == ""){
                binding.mainView.text = "please enter number!!!"
            }else{
                val res = game.ingame(binding.inView.text.toString().toInt())
                if (binding.inView.text.toString().toInt() != game.secr){
                    binding.mainView.text = res
                }else if(binding.inView.text.toString().toInt() == game.secr){
                    binding.ANS.text = ans
                    handler.postDelayed({
                        Toast.makeText(this,"6秒後的操作執行了",Toast.LENGTH_SHORT).show()
                        binding.mainView.text = "please enter number"
                        binding.ANS.text = ""
                        game.re()
                    },6000)

                }
            }
        }
        /*ANS.text = secr.toString()*/
        binding.reset.setOnClickListener{
            //secr = Random.nextInt(100) + 1
            binding.mainView.text = "please enter number"
            /*ANS.text = secr.toString()*/
            binding.ANS.text = ""
            //max = 100
            //min = 1
            game.re()
        }

    }
    override fun  onDestroy(){
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}