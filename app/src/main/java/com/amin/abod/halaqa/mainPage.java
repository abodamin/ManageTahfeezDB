package com.amin.abod.halaqa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class mainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("ShaPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        boolean  firstTime = sharedPreferences.getBoolean("first", true);
        if(firstTime) {
            editor.putBoolean("first", false);
            //For commit the changes, Use either editor.commit(); or  editor.apply();.
            editor.commit();
            Intent halaqa = new Intent(mainPage.this, addHalaqa.class);
            Intent teacher = new Intent(mainPage.this, addTeacher.class);
            startActivity(halaqa);
            startActivity(teacher);
        }
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

    }

}
