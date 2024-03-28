package com.example.hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random

class RPSActivity : AppCompatActivity() {
    private  lateinit var txtResult: TextView
    private  lateinit var imbtnScissore: ImageButton
    private  lateinit var imbtnRock: ImageButton
    private  lateinit var imbtnPaper: ImageButton
    private  lateinit var imageView: ImageView
    private  lateinit var  back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rpsactivity)

        txtResult = findViewById(R.id.txtResult)
        imbtnScissore = findViewById(R.id.imbtnScissore)
        imbtnRock = findViewById(R.id.imbtnRock)
        imbtnPaper = findViewById(R.id.imbtnPaper)
        imageView = findViewById(R.id.imageView)
        back = findViewById(R.id.back_RPS)

        imbtnScissore.setOnClickListener {
            //imageView.setImageResource(R.drawable.scissor)
            playGame(Choice.SCISSORS)
        }
        imbtnRock.setOnClickListener {
            //imageView.setImageResource(R.drawable.rock)
            playGame(Choice.ROCK)
        }
        imbtnPaper.setOnClickListener {
            //imageView.setImageResource(R.drawable.paper)
            playGame(Choice.PAPER)
        }
        back.setOnClickListener {
            finish()
        }
    }
    enum class Choice{
        SCISSORS, ROCK, PAPER
    }
    fun playGame(playerChoice: Choice){
        val choice = Choice.values()
        val computerChoice = choice[Random.nextInt(choice.size)]
        getChoiceImage(computerChoice)
        when {
            playerChoice == computerChoice -> {
                txtResult.setText(R.string.draw)
            }
            (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) ||
                    (playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                    (playerChoice == Choice.PAPER && computerChoice == Choice.ROCK) -> {
                txtResult.setText(R.string.win)
            }
            else -> {
                txtResult.setText(R.string.lose)
            }
        }
    }
    fun getChoiceString(choice: Choice): Int {
        return when (choice){
            Choice.SCISSORS -> R.string.scissors
            Choice.ROCK -> R.string.rock
            Choice.PAPER -> R.string.paper
        }
    }
    fun getChoiceImage(choice: Choice){
        when (choice){
            Choice.SCISSORS -> imageView.setImageResource(R.drawable.scissor)
            Choice.ROCK -> imageView.setImageResource(R.drawable.rock)
            Choice.PAPER -> imageView.setImageResource(R.drawable.paper)
        }
    }
    var lastTime: Long = 0
    override fun finish(){
        val currentTime = System.currentTimeMillis()
        if(currentTime - lastTime > 3 * 1000){
            lastTime = currentTime
            Toast.makeText(this,"在案一次離開", Toast.LENGTH_SHORT).show()
        }else  {
            super.finish()
        }
    }
}