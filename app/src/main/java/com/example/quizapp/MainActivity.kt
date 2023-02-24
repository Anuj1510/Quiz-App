package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN /* ye full screen ke liye hai...
                                                                               agr mujhe upper se bar hatana ho
                                                                               jisme battery wagera dikhta hai to
                                                                               ye use kr sakte hai */

        btn_start.setOnClickListener {

            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,QuizQuestionActivity::class.java)// ye hamme dusri activity mai le jaayega
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent) // ye new activity start karega jisse hum call kar rahe hai
                finish() // ye old activity ko close kr dega
                Toast.makeText(this,"Lets Start the Quiz",Toast.LENGTH_LONG).show()
            }

        }

    }
}