package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        final Intent toNewStudent = new Intent(addStudent.this,addNewStudent.class);
        final Intent toHaveBrother = new Intent(addStudent.this,addStudentHaveBrother.class);

        Button btnNewStudent = (Button) findViewById(R.id.btnNewStudent);
        Button btnHaveBrother = (Button) findViewById(R.id.btnHaveBrother);

        btnNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toNewStudent);
            }
        });

        btnHaveBrother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toHaveBrother);
            }
        });

    }
}
