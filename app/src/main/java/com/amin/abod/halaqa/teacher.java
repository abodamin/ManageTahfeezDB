package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class teacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        final Intent toAddTeacher = new Intent(teacher.this,addTeacher.class);
        Button btnAddTeacher = (Button) findViewById(R.id.btnAddTeacher);
    }
    /*    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        final Intent toStudent = new Intent(mainPage.this ,students.class);
        final Intent toHalaqat = new Intent(mainPage.this ,halaqat.class);
        final Intent toTeacher = new Intent(mainPage.this , teacher.class);
        final Intent toManagement = new Intent(mainPage.this , management.class);

        Button btnStudent = (Button) findViewById(R.id.btnStudent);
        Button btnHalaqa = (Button) findViewById(R.id.btnHalaqa);
        Button btnTeacher = (Button) findViewById(R.id.btnTeacher);
        Button btnManagement = (Button) findViewById(R.id.btnManagement);

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toStudent);
            }
        });

        btnHalaqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toHalaqat);
            }
        });

        btnTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toTeacher);
            }
        });

        btnManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toManagement);
            }
        });

    }*/
}
