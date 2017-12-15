package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class students extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        final Intent toFollowHifz = new Intent(students.this, followHifz.class);
        final Intent toAddStudent = new Intent(students.this, addStudent.class);
        final Intent toViewStudent = new Intent(students.this, viewStudents.class);
        final Intent toUpdateStudent = new Intent(students.this, updateStudent.class);

        Button btnFollowHifz = (Button) findViewById(R.id.btnHifz);
        Button btnAddStudent = (Button) findViewById(R.id.btnAddStudent);
        Button btnViewStudents = (Button) findViewById(R.id.btnViewStudent);
        Button btnUpdateStudent = (Button) findViewById(R.id.btnUpdateStudent);

        btnFollowHifz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toFollowHifz);
            }
        });

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toAddStudent);
            }
        });

        btnViewStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toViewStudent);
            }
        });

        btnUpdateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toUpdateStudent);
            }
        });
    }
}
