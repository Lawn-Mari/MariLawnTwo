package com.marinamari.marilawntwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.marinamari.marilawntwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 10 seconds

    private lateinit var binding: ActivityMainBinding
    private lateinit var answerOne: Button
    private lateinit var answerTwo: Button
    private lateinit var answerThree: Button
    private lateinit var answerFour: Button
    private lateinit var questionView: TextView
    private lateinit var jim: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        answerOne = findViewById(R.id.answerOne)
        answerTwo = findViewById(R.id.answerTwo)
        answerThree = findViewById(R.id.answerThree)
        answerFour = findViewById(R.id.answerFour)
        questionView = findViewById(R.id.question)
        jim = findViewById(R.id.jim)

        var questionOneActive = true
        var questionTwoActive = false
        var buttonNum = 0
        val questionOneNum = 2
        val questionTwoNum = 3

            questionView.text = "What color was the orange?"
            answerOne.text = "Orange"
            answerTwo.text = "Blue"
            answerThree.text = "Red"
            answerFour.text = "What orange?"
            jim.visibility = View.GONE

        fun checker() {
            if (questionOneActive) {
                if (buttonNum == questionOneNum) {
                    questionOneActive = false
                    buttonNum = 0
                    questionTwoActive = true
                } else {
                    questionOneActive = false
                    questionView.text = "WRONG!"
                }
            } else if (questionTwoActive) {
                if (buttonNum == questionTwoNum) {
                    questionTwoActive = false
                    questionView.text = "Correct!"
                } else {
                    questionTwoActive = false
                    questionView.text = "WRONG!"
                }
            }

            if (questionOneActive && !questionTwoActive) {
                questionView.text = "What color was the orange?"
                answerOne.text = "Orange"
                answerTwo.text = "Blue"
                answerThree.text = "Red"
                answerFour.text = "What orange?"
                jim.visibility = View.GONE
            } else if (!questionOneActive && questionTwoActive) {
                questionView.text = "Who is this?"
                answerOne.text = "DRAKE?!"
                answerTwo.text = "Huh"
                answerThree.text = "Not Douglas"
                answerFour.text = "Doug Doug Doug Doug"
                jim.visibility = View.VISIBLE
            }
        }
        answerOne.setOnClickListener {
            buttonNum = 1
            checker()
        }

        answerTwo.setOnClickListener {
            buttonNum = 2
            checker()
        }

        answerThree.setOnClickListener {
            buttonNum = 3
            checker()
        }

        answerFour.setOnClickListener {
            buttonNum = 4
            checker()
        }

    }
}