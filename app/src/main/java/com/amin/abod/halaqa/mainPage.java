package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);
        final Intent toStudent = new Intent(mainPage.this ,students.class);
        final Intent toHalaqat = new Intent(mainPage.this ,halaqat.class);
        final Intent toTeacher = new Intent(mainPage.this , teacher.class);

        Button btnStudent = (Button) findViewById(R.id.btnStudent);
        Button btnHalaqa = (Button) findViewById(R.id.btnHalaqa);
        Button btnTeacher = (Button) findViewById(R.id.btnTeacher);
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



    }
}
