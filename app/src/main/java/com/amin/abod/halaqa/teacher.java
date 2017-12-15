package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class teacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        final Intent toAddTeacher = new Intent(teacher.this,addTeacher.class);
        Button btnAddTeacher = (Button) findViewById(R.id.btnAddTeacher);

        final Intent toViewTeachers = new Intent(teacher.this,viewTeachers.class);
        Button btnViewTeachers = (Button) findViewById(R.id.btnViewTeachers);

        final Intent toEditTeachers = new Intent(teacher.this,editTeacher.class);
        Button btnEditTeacher = (Button) findViewById(R.id.btnEditTeacher);


        btnAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toAddTeacher);
            }
        });

        btnViewTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toViewTeachers);
            }
        });

        btnEditTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toEditTeachers);
            }
        });
    }
}
