package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {

    private var mcurrentposition:Int = 1
    private var mquestionslist: ArrayList<Question>? = null
    private var mselectedoptionposition: Int = 0
    private var mcorrectanswers:Int = 0;
    private var musername:String? = null




    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        musername = intent.getStringExtra(Constants.USER_NAME)

        mquestionslist = Constants.getQuestions()
        Log.i("Questions Size","${mquestionslist!!.size}") // this will help to get the number of questions

//        val currentposition = 1
//        val question: Question? = questionsList[currentposition - 1]
//
//        progressbar.progress = currentposition
//        tv_progress.text = "$currentposition" + "/" + progressbar.max
//        tv_question.text = question!!.question
//        tv_image.setImageResource(question.image)
//        tv_option_one.text = question.optionOne
//        tv_option_two.text = question.optionTwo
//        tv_option_three.text = question.optionThree
//        tv_option_four.text = question.optionFour

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion(){
        val question =  mquestionslist!![mcurrentposition - 1]

        defaultOptionsView()

        if(mcurrentposition == mquestionslist!!.size){
            btn_submit.text = "FINISH"
        }
        else{
            btn_submit.text = "SUBMIT"
        }

        progressbar.progress = mcurrentposition
        tv_progress.text = "$mcurrentposition" + "/" + progressbar.max

        tv_question.text = question!!.question
        tv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg

            )
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{
                selectedoptionview(tv_option_one,1)
            }
            R.id.tv_option_two ->{
                selectedoptionview(tv_option_two,2)
            }
            R.id.tv_option_three ->{
                selectedoptionview(tv_option_three,3)
            }
            R.id.tv_option_four ->{
                selectedoptionview(tv_option_four,4)
            }
            R.id.btn_submit -> {
                if(mselectedoptionposition == 0){
                    mcurrentposition ++

                    when{
                        mcurrentposition <= mquestionslist!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,musername)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mcorrectanswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mquestionslist!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mquestionslist?.get(mcurrentposition - 1)
                    if(question!!.correctAnswer != mselectedoptionposition){
                        answerview(mselectedoptionposition, R.drawable.wrong_option_border_bg)
                    }else{
                        mcorrectanswers++
                    }
                    answerview(question.correctAnswer, R.drawable.correct_option_border_bg) // isko hamne else mai isliye nahi dala taaki agr hum galat answer bhi select kare to correct answer apne aap green ho jaaye



                    if(mcurrentposition == mquestionslist!!.size){
                        btn_submit.text = "FINISH"
                    }
                    else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mselectedoptionposition = 0


                }
            }
        }
    }

    private fun answerview(answer: Int, drawableview: Int){
        when(answer){
            1->{
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableview
                )
            }
            2->{
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableview
                )
            }
            3->{
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableview
                )
            }
            4->{
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableview
                )
            }
        }
    }

    private fun selectedoptionview(tv:TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mselectedoptionposition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.typeface = Typeface.DEFAULT
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg

        )
    }

}