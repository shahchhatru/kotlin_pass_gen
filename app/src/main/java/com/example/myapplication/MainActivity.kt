package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    val letters = "abcdefghijklmnopqrstuvwxyz"
    val uppercaseLetters : String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val numbers : String = "0123456789"
    val special : String = "@#=+!£$%&?"
    lateinit var MyButton:Button
    lateinit var myTextView: TextView
    lateinit var myEditNumView:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyButton=findViewById(R.id.button2)
        myTextView=findViewById(R.id.digit_len_tv)
        myEditNumView=findViewById(R.id.editTextNumber)
        MyButton.setOnClickListener {
            call_password_generator(it)
        }
    }



    private fun generatePassword(view: View, p_size:Int){
        var genPassword:String =""
        for(i in 1..p_size) {
            val genChar:Char = when (Random().nextInt(4) + 1) {
                1 -> letters[Random().nextInt(letters.length)]
                2 -> uppercaseLetters[Random().nextInt(uppercaseLetters.length)]
                3 -> numbers[Random().nextInt(numbers.length)]
                else -> special[Random().nextInt(special.length)]
            }
            genPassword+=genChar;


        }
        myTextView.text=genPassword
    }

    private fun call_password_generator(view:View){
        var i:Int =Integer.parseInt(myEditNumView.text.toString())

        generatePassword(view,i)
    }
}