package com.example.hp.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hp.quizapp.QuizContract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.Table_Name + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.Table_Name);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        //delaration questions
        Question q1 = new Question("Which of the following is syntactically wrong", "int a;", "int 1c;", "int _a", 2);
        addQuestion(q1);
        Question q2 = new Question(" Identify Error public class Student{}\n" +
                "public class ABC{}", "Compilation error", "Runtime Error", "No Error", 1);
        addQuestion(q2);
        Question q3 = new Question("Which of the following is true regarding source code file", "File name can be anything", "File name must match with public class name", "File name must match with nonpublic file", 2);
        addQuestion(q3);
        Question q4 = new Question("Which of the following is correct syntax of declaring enum", "enum Days{MON.TUE,WED}", "enum Days{MON,TUE,WED};", "Both", 3);
        addQuestion(q4);
        Question q5 = new Question("How many access modifiers are there in java", "2", "3", "4", 3);
        addQuestion(q5);
        Question q6 = new Question("Which of the following class will not compile", "class A{}", "public class B{}", "protected class B{}", 3);
        addQuestion(q6);
        Question q7 = new Question("Which class will be accessible in same Package but not outside", "class X{}", "public class Y{}", "private class Z{}", 1);
        addQuestion(q7);
        Question q8 = new Question("Which of the following method will not compile", "public void show{int a=10;}", "public void show{final int b=10;}", "public void show{private int c=10;}", 3);
        addQuestion(q8);
        Question q9 = new Question("Which of the following method will not compile", "public void MM(){int a; int b=a;)", "public void MM(){final int a;}", "public void MM(){int a;}", 1);
        addQuestion(q9);
        Question q10 = new Question("Which of the following is true about static", "there is only one copy of static variables", "static variable is accessed using class name", "Both", 3);
        addQuestion(q10);
        Question q11 = new Question("Which following method name does not follow javaBeans standards", "putData", "getData", "setData", 1);
        addQuestion(q11);
        Question q12 = new Question("Instance variable can have", "only public access modifier", "only public or private", "all access modifier", 3);
        addQuestion(q12);

       // datatype questions
        Question q13= new Question("What is the range of 'byte' datatype in java", "-128 to 127", "-32768 to 32767", "1.7e-308", 1);
        addQuestion(q13);
        Question q14 = new Question("What is the range of 'int' datatype in java", "-32768 to 32767", "-2,147,483,648 to 2,147,483,647", "1.7e-308", 2);
        addQuestion(q14);
        Question q15 = new Question("output?\n" +
                "class abc{ psvm(String[] args){\n" +
                "long a=2345334456;\n" +
                "int i=(int)a;\n" +
                "System.out.println(i);}}\n", "unexpected", "compiletime error", "2345334456", 2);
        addQuestion(q15);
        Question q16 = new Question("what is range of char datatype in java", "0 to 65,535", "1.7e-308", "32768 to 32767", 1);
        addQuestion(q16);
        Question q17 = new Question("What is default value of 'char' in java ", "0", "null", "u0000", 3);
        addQuestion(q17);
        Question q18 = new Question("output?\n" +
                "class mpq{ psvm(String[] args){\n" +
                "float f=100.0;\n" +
                "System.out.println(f);}}\n", "100.0", "compile time error", "runtime error", 2);//100.0 is double
        addQuestion(q18);
        Question q19 = new Question("output?\n" +
                "class mpq{ psvm(String[] args){\n" +
                "char c=66;\n" +
                "System.out.println(c);}}\n", "66", "compile time error", "B", 3);
        addQuestion(q19);
        Question q20 = new Question("Which following coding type is used for 'char' in java", "ASCII", "ISCII", "unicode", 3);
        addQuestion(q20);

        //arrays
        Question q21 = new Question("public class Arrays{\n" +
                "psvm(String[] arg){\n" +
                "int arr[]=new int[5];\n" +
                "System.out.println(arr.length);}}\n", "5", "2", "0", 1);
        addQuestion(q21);
        Question q22 = new Question("which of the foloowing is wrong syntax for declaring arrays", "Student[] s=new Person[4]", "Student s[3]", "Student[] s [];", 2);
        addQuestion(q22);
        Question q23 = new Question("public class Arrays{\n" +
                "psvm(String[] args){\n" +
                "int ar1[]=new int[5];\n" +
                "System.out.println(ar1[4]);}}\n", "no output", "0", "compile time error", 2);
        addQuestion(q23);
        Question q24 = new Question("public class Arrays{\n" +
                "psvm(String[] args){\n" +
                "int []arr=new int[3];\n" +
                "arr[0]=0;\n" +
                "arr[1]=1;\n" +
                "System.out.println(arr);}}\n", "0", "compilation error", "hashcode", 3);
        addQuestion(q24);
        Question q25 = new Question("which is wrong syntax for declaring 2-D array", "int arr[][]=new int[5][];", "int []arr[]=new int[5][]", "none of above", 3);
        addQuestion(q25);
        Question q26 = new Question("public class arrays{\n" +
                "psvm(String[] args){\n" +
                "int arr[]={5,8,7,2,3};\n" +
                "for(int i=1;i<arr.length-1;++i){\n" +
                "System.out.println(arr[i]);}}}\n", "5 8 7 2", " 8 7 2", "8 7 2 3", 2);
        addQuestion(q26);
        Question q27 = new Question("public class Arrays{\n" +
                "psvm(String[] args){\n" +
                "int []arr[]=new int[5];\n" +
                "arr[1]=new int[5];\n" +
                "System.out.println(arr[0])}};\n", "0", "null ", "hashcode", 2);
        addQuestion(q27);
        Question q28 = new Question("What should be return type of method which return float array", "float[]", "[]float", "float", 1);
        addQuestion(q28);
        Question q29 = new Question("Which following method can accept long 2-D array as argument", "display([]long[] a)", "display(long[][] a)", "display([][]long a)", 2);
        addQuestion(q29);

        //Strings





    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.Table_Name, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.Table_Name, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}