package com.example.guess_number

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import kotlin.random.Random

class guess_game (){
    var secr : Int = Random.nextInt(100) + 1
    var max:Int = 100
    var min:Int = 1
    fun ingame(inView: Int): String{
        var inView_text:Int = inView
        var mainView_text: String = ""
        var ANS_text: String = ""
        if(inView_text > secr){
            max = inView_text
        }else if(inView_text < secr){
            min = inView_text
        }
        mainView_text = min.toString() + "-" + max.toString()

        return mainView_text
    }
    fun re(){
        max = 100
        min = 1
        secr = Random.nextInt(100) + 1
    }

}