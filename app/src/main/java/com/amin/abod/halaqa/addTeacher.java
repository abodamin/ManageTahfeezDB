package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class addTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
    }
    /* db.execSQL("create table "+DB_Table_Teacher +"(" +  //teacher
                " TSSN INTEGER" +     //teacher SSN
                ",Tname TEXT" +     //* F,L
                ", Mobile TEXT" +
                ", PRIMARY KEY (TSSN) )");*/
}
