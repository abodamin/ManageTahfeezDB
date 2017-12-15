package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

public class addTeacher extends AppCompatActivity {
MyDataBase myDataBase = new MyDataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        final EditText teacherName = (EditText) findViewById(R.id.insertTeacherName);
        final EditText teacherMobile = (EditText) findViewById(R.id.insertTeacherMobile);
        final EditText teacherSSN = (EditText) findViewById(R.id.insertTeacherSSN);

        Button btnAddTeacher = (Button) findViewById(R.id.btnInsertTeacherInfo);

        btnAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tSSN = Integer.parseInt(teacherSSN.getText().toString().trim());
                String tName = teacherName.getText().toString().trim();
                String tMobile = teacherMobile.getText().toString().trim();
                long result = myDataBase.setTeacherDate(tSSN, tName, tMobile);

                if(result==-1){
                    Toast.makeText(addTeacher.this, " Error occured ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(addTeacher.this, " Added succefuly ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
