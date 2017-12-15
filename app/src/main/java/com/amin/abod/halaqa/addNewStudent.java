package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

public class addNewStudent extends AppCompatActivity {
MyDataBase myDataBase = new MyDataBase(this);   //parameter in the constructor takes Context

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        final EditText studentName = (EditText) findViewById(R.id.insertStudentName);
        final EditText studentSSN = (EditText) findViewById(R.id.insertٍStudentSSN);
        final EditText studentMobile = (EditText) findViewById(R.id.insertٍStudentMobile);
        final EditText studentStartHifz = (EditText) findViewById(R.id.insertStartHifz);
        final EditText parentName = (EditText) findViewById(R.id.insertParentName);
        final EditText parentMobile = (EditText) findViewById(R.id.insertٍParentMobile);
        final EditText  parentSSN = (EditText) findViewById(R.id.insertٍParentSSN);
        final EditText  sHalaqaName = (EditText) findViewById(R.id.insertHalaqaName);

        Button btnAddStudent = (Button) findViewById(R.id.btnInsertNewStudent);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //          *** Parent Data ***
                String pName = parentName.getText().toString().trim();
                int pSSN = Integer.parseInt(parentSSN.getText().toString().trim());//taking integers must be like this as i know :)
                String pMobile = parentMobile.getText().toString().trim();

                long result1 = myDataBase.setParentData(pName,pSSN,pMobile);

                //          ***  Getting Student Data ***
                String sName = studentName.getText().toString().trim();
                int sSSN = Integer.parseInt(studentSSN.getText().toString().trim());
                String sHifz = studentStartHifz.getText().toString().trim();
                String sHalaqa = sHalaqaName.getText().toString().trim();       // has to find a way to get it from UI
                String sMobile = studentMobile.getText().toString().trim();
                int paSSN = Integer.parseInt(parentSSN.getText().toString().trim());

                long result2 = myDataBase.setData(sName , sSSN , sHifz , sHalaqa , sMobile, paSSN);

                if (result1 == -1 || result2 == -1) {
                    Toast.makeText(addNewStudent.this, " Error occure ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(addNewStudent.this, " Addid succesfuly ", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
