package com.example.hp.quizapp;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract(){
        //we made constructor private so that we accidently does not make
        //object of this class and cannot change this class
    }

    public static class QuestionsTable implements BaseColumns{
        public static final String Table_Name="quiz_questions";
        public static final String COLUMN_QUESTION="question";
        public static  final String COLUMN_OPTION1 ="option1";
        public static  final String COLUMN_OPTION2 ="option2";
        public static  final String COLUMN_OPTION3 ="option3";
        public static  final String COLUMN_ANSWER_NR ="answer_nr";
    }
}
