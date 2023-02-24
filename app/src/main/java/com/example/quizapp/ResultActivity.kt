package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_quiz_question.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        var randomnumber = correctAnswer
        var imageofresult :Int = 1
        when (randomnumber) {
            0->{
                imageofresult = R.drawable.fail
            }
            1 -> {
                imageofresult = R.drawable.fail
            }
            2 -> {
                imageofresult = R.drawable.fail
            }
            3 -> {
                imageofresult = R.drawable.fail
            }
            4 -> {
                imageofresult = R.drawable.fail
            }
            5 -> {
                imageofresult=R.drawable.win
            }
            6 -> {
                imageofresult=R.drawable.win
            }
            7->{
                imageofresult=R.drawable.win
            }
            8->{
                imageofresult=R.drawable.win
            }
            9->{
                imageofresult=R.drawable.win
            }
            10->{
                imageofresult=R.drawable.images
            }
        }
        tv_result.setImageResource(imageofresult)

        tv_score.text = "Your Score is $correctAnswer out of $totalQuestions"

        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}