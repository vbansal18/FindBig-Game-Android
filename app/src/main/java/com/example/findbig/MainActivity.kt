package com.example.findbig

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNumbers(leftBtn,rightBtn)
        var currScore : Int = 0
        leftBtn.isClickable = true
        rightBtn.isClickable = true
        leftBtn.setOnClickListener(){
            // Compare the two button values
            if(leftBtn.text.toString().toInt()>=rightBtn.text.toString().toInt()){
//                Change background color to green
                activity.setBackgroundColor(Color.GREEN)
//                Correct answer

                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show()
                currScore++
                score.text = "Score : $currScore"
            }
            else{
//                Change background color to green
                activity.setBackgroundColor(Color.RED)
//                Correct answer
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()

                leftBtn.isClickable = false
                rightBtn.isClickable = false
                score.text = "Total Score : $currScore"
                currScore=0
                playAgain.visibility = View.VISIBLE
                playAgain.setOnClickListener {
                    val intent = Intent(this, this::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            // Pick new random numbers and set them in buttons
            setNumbers(leftBtn,rightBtn)

        }
        rightBtn.setOnClickListener(){
            // Compare the two button values
            if(leftBtn.text.toString().toInt()<=rightBtn.text.toString().toInt()){
//                Change background color to green
                activity.setBackgroundColor(Color.GREEN)
//                Correct answer
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show()
                currScore++
                score.text = "Score : $currScore"
            }
            else{
//                Change background color to green
                activity.setBackgroundColor(Color.RED)
//                Correct answer
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()

                leftBtn.isClickable = false
                rightBtn.isClickable = false
                score.text = "Total Score : $currScore"
                currScore=0
                playAgain.visibility = View.VISIBLE
                playAgain.setOnClickListener {
                    val intent = Intent(this, this::class.java)
                    startActivity(intent)
                    finish()
                }
            }



            // Pick new random numbers and set them in buttons
            setNumbers(leftBtn,rightBtn)

        }
    }

    private fun setNumbers(leftBtn: Button, rightBtn: Button) {
        leftBtn.text = (0..10).random().toString()
        while(rightBtn.text==leftBtn.text){
            rightBtn.text = (0..10).random().toString()
        }

    }
}