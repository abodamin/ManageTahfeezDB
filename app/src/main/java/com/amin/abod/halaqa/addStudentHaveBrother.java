package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

import java.util.List;

public class addStudentHaveBrother extends AppCompatActivity {
MyDataBase myDataBase = new MyDataBase(this);

    Spinner halaqaSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_has_brother);

        // Spinner element
        halaqaSpinner = (Spinner) findViewById(R.id.spinnerHalaqatList);

        loadSpinnerData();


        final EditText studentName = (EditText) findViewById(R.id.insertStudentName);
        final EditText studentSSN = (EditText) findViewById(R.id.insertٍStudentSSN);
        final EditText studentMobile = (EditText) findViewById(R.id.insertٍStudentMobile);
        final EditText studentStartHifz = (EditText) findViewById(R.id.insertStartHifz);
        final EditText  parentSSN = (EditText) findViewById(R.id.insertٍParentSSN);
        //final EditText  sHalaqaName = (EditText) findViewById(R.id.insertHalaqaName); replaced by spinner

        Button btnAddStudent = (Button) findViewById(R.id.btnInsertNewStudent);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to check the parent ID is there already or not then add the student
                // but it is crashing when we add exixsting parent id :\String sName = studentName.getText().toString().trim();
                String sName = studentName.getText().toString().trim();
                int sSSN = 0;
                int paSSN = 0;
                String sSSNText = studentSSN.getText().toString().trim();
                String sHifz = studentStartHifz.getText().toString().trim();
                String sHalaqa = halaqaSpinner.getSelectedItem().toString();
                String sMobile = studentMobile.getText().toString().trim();
                String paSSNText = parentSSN.getText().toString().trim();
                if (! TextUtils.isEmpty(sSSNText)) sSSN = Integer.parseInt(sSSNText);
                if (! TextUtils.isEmpty(paSSNText)) paSSN = Integer.parseInt(paSSNText);
                long result=0,result1=0;

                if(! TextUtils.isEmpty(sName) && ! TextUtils.isEmpty(sHifz) && ! TextUtils.isEmpty(sSSNText) && ! TextUtils.isEmpty(sHalaqa) && ! TextUtils.isEmpty(sMobile) && ! TextUtils.isEmpty(paSSNText) && result1 == 0) {
                    result = myDataBase.setStudentData(sName, sSSN, sHifz, sHalaqa, sMobile, paSSN);
                    result1 = 5;
                }
                else if(TextUtils.isEmpty(sName)){
                    studentName.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addStudentHaveBrother.this, " يجب إدخال اسم الطالب ", Toast.LENGTH_LONG).show();
                    result1=-1;
                }
                else if(TextUtils.isEmpty(sSSNText)){
                    studentSSN.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addStudentHaveBrother.this, " يجب إدخال رقم هوية الطالب ", Toast.LENGTH_LONG).show();
                    result1=-1;
                }
                else if(TextUtils.isEmpty(sMobile)){
                    studentMobile.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addStudentHaveBrother.this, " يجب إدخال رقم جوال الطالب ", Toast.LENGTH_LONG).show();
                    result1=-1;
                }
                else if(TextUtils.isEmpty(sHifz)){
                    studentStartHifz.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addStudentHaveBrother.this, " يجب إدخال آخر سورة يحفظها الطالب ", Toast.LENGTH_LONG).show();
                    result1=-1;
                }
                else if(TextUtils.isEmpty(paSSNText)){
                    parentSSN.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addStudentHaveBrother.this, " يجب إدخال رقم هوية المعلم ", Toast.LENGTH_LONG).show();
                    result1=-1;
                }
                // If all good, will check if there's Query error on setting halaqa.
                if(result1==5) {
                    if (result == -1) {
                        Toast.makeText(addStudentHaveBrother.this, " خطأ في الادخال ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(addStudentHaveBrother.this, " تمت اضافة الطالب بنجاح ", Toast.LENGTH_SHORT).show();
                        refreshing();
                    }
                }
                   
            }
        });


    }

    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(4);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        halaqaSpinner.setAdapter(dataAdapter);
    }

    public void refreshing (){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
