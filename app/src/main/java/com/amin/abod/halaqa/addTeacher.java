package com.amin.abod.halaqa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
                int tSSN = 0;
                long result=0,result1=0;
                String tSSNText = teacherSSN.getText().toString().trim();
                if (! TextUtils.isEmpty(tSSNText)) tSSN = Integer.parseInt(tSSNText);
                String tName = teacherName.getText().toString().trim();
                String tMobile = teacherMobile.getText().toString().trim();
                if(! TextUtils.isEmpty(tName) && ! TextUtils.isEmpty(tMobile) && ! TextUtils.isEmpty(tSSNText) && result1==0){
                    result = myDataBase.setTeacherDate(tSSN, tName, tMobile);
                    result1 = 5;
                }
                else if(TextUtils.isEmpty(tName)) {
                    teacherName.setError("يجب إدخال اسم المعلم");
                    result1=-1;
                }
                else if(TextUtils.isEmpty(tSSNText)){
                    teacherSSN.setError("يجب إدخال رقم هوية المعلم");
                    result1=-1;
                }else if(TextUtils.isEmpty(tMobile)){
                    teacherMobile.setError("يجب إدخال رقم جوال المعلم");
                    result1=-1;
                }
                if(result1==5) {
                    if (result == -1) {
                        Toast.makeText(addTeacher.this, " خطأ بالادخال ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(addTeacher.this, " تم اضافة المعلم بنجاح ", Toast.LENGTH_SHORT).show();
                        refreshing();
                    }
                }
            }
        });

    }

    public void refreshing (){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
