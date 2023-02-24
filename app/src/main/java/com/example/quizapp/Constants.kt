package com.example.quizapp

object Constants{ // ye saree questions contain karega

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_question"
    const val CORRECT_ANSWERS:String = "correct_ansewrs"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        var i: Int = 0
        val myset : MutableSet<Int> = mutableSetOf()

        while(i<10){

            val randomnumber = (1..10).random()
            if(!myset.contains(randomnumber)){
                myset.add(randomnumber)
                when(randomnumber){
                    1->{
                        val que1 = Question(1,"What country does this flag belong to?",
                            R.drawable.argentina,"Argentina","Australia"
                            ,"Armenia","Austria",1
                        )

                        questionList.add(que1)
                    }
                    2->{

                        val que2 = Question(2,"What country does this flag belong to?",
                            R.drawable.belgium,"Belgium","Australia"
                            ,"Armenia","Austria",1
                        )

                        questionList.add(que2)
                    }
                    3->{
                        val que3 = Question(3,"What country does this flag belong to?",
                            R.drawable.australia,"Argentina","Australia"
                            ,"Armenia","Austria",2
                        )

                        questionList.add(que3)
                    }
                    4->{
                        val que4 = Question(4,"What country does this flag belong to?",
                            R.drawable.brazil,"Brazil","Australia"
                            ,"Armenia","Austria",1
                        )

                        questionList.add(que4)
                    }

                    5->{
                        val que5 = Question(5,"What country does this flag belong to?",
                            R.drawable.denmark,"Denmark","Australia"
                            ,"Armenia","Austria",1
                        )

                        questionList.add(que5)

                    }
                    6->{

                        val que6 = Question(6,"What country does this flag belong to?",
                            R.drawable.fiji,"Fiji","Australia"
                            ,"Armenia","Austria",1
                        )

                        questionList.add(que6)
                    }
                    7->{
                        val que7 = Question(7,"What country does this flag belong to?",
                            R.drawable.germany,"Germany","Australia"
                            ,"Armenia","Austria",1
                        )

                        questionList.add(que7)

                    }
                    8->{
                        val que8 = Question(8,"What country does this flag belong to?",
                            R.drawable.india,"India","Australia"
                            ,"Armenia","Austria",1
                        )

                        questionList.add(que8)
                    }
                    9->{
                        val que9 = Question(9,"What country does this flag belong to?",
                            R.drawable.kuwait,"Kuwait","Australia"
                            ,"Armenia","Austria",1
                        )

                        questionList.add(que9)
                    }
                    10->{
                        val que10 = Question(10,"What country does this flag belong to?",
                            R.drawable.new_zealand,"New Zealand","Australia"
                            ,"Armenia","Austria",1
                        )

                        questionList.add(que10)
                    }
                }
                i++
            }

        }
        return questionList

    }


}