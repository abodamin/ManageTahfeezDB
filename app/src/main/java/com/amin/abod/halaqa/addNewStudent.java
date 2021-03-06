package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

import java.util.List;

public class addNewStudent extends AppCompatActivity {
MyDataBase myDataBase = new MyDataBase(this);   //parameter in the constructor takes Context

    RadioButton parentExist;
    Spinner halaqaSpinner;
    EditText parentName;
    EditText parentMobile;
    EditText  parentSSN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        // Spinner element
        halaqaSpinner = (Spinner) findViewById(R.id.spinnerHalaqatList);

        loadSpinnerData();

        parentExist  = (RadioButton) findViewById(R.id.parentExist);

        final EditText studentName = (EditText) findViewById(R.id.insertStudentName);
        final EditText studentSSN = (EditText) findViewById(R.id.insertٍStudentSSN);
        final EditText studentMobile = (EditText) findViewById(R.id.insertٍStudentMobile);
        final EditText studentStartHifz = (EditText) findViewById(R.id.insertStartHifz);
        parentName = (EditText) findViewById(R.id.insertParentName);
        parentName.setVisibility(View.GONE);
        parentMobile = (EditText) findViewById(R.id.insertٍParentMobile);
        parentMobile.setVisibility(View.GONE);
        parentSSN = (EditText) findViewById(R.id.insertٍParentSSN);
        parentSSN.setVisibility(View.GONE);
        //final EditText  sHalaqaName = (EditText) findViewById(R.id.insertHalaqaName);

        onParentExistButtonClick();
        Button btnAddStudent = (Button) findViewById(R.id.btnInsertNewStudent);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pSSN=0;
                long result1 = 0,result3=0,result2=0,result4=0;
                String pName = parentName.getText().toString().trim();
                String pSSNText = parentSSN.getText().toString().trim();
                if (! TextUtils.isEmpty(pSSNText)) pSSN = Integer.parseInt(pSSNText); //because we cant check if empty of integers
                String pMobile = parentMobile.getText().toString().trim();
                int sSSN = 0;
                String sSSNText = studentSSN.getText().toString().trim();
                String sName = studentName.getText().toString().trim();
                if (! TextUtils.isEmpty(sSSNText)) sSSN = Integer.parseInt(sSSNText);
                String sHifz = studentStartHifz.getText().toString().trim();
                String sHalaqa = halaqaSpinner.getSelectedItem().toString();


                String sMobile = studentMobile.getText().toString().trim();

                /* check student fields first */
                // every field is -1 if it's empty
                if(! TextUtils.isEmpty(sName) && ! TextUtils.isEmpty(sHifz) && ! TextUtils.isEmpty(sSSNText) && ! TextUtils.isEmpty(sHalaqa) && ! TextUtils.isEmpty(sMobile) && result4 == 0) {
                    result4 = 5;
                }
                else if(TextUtils.isEmpty(sName)){
                    studentName.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addNewStudent.this, " يجب إدخال اسم الطالب ", Toast.LENGTH_LONG).show();
                    result4=-1;
                }
                else if(TextUtils.isEmpty(sSSNText)){
                    studentSSN.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addNewStudent.this, " يجب إدخال رقم هوية الطالب ", Toast.LENGTH_LONG).show();
                    result4=-1;
                }
                else if(TextUtils.isEmpty(sMobile)){
                    studentMobile.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addNewStudent.this, " يجب إدخال رقم جوال الطالب ", Toast.LENGTH_LONG).show();
                    result4=-1;
                }
                else if(TextUtils.isEmpty(sHifz)){
                    studentStartHifz.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addNewStudent.this, " يجب إدخال آخر سورة يحفظها الطالب ", Toast.LENGTH_LONG).show();
                    result4=-1;
                }

                /* if Student text fields are filled then check parents */
                if(result4==5){
                if(! TextUtils.isEmpty(pName) && ! TextUtils.isEmpty(pMobile) && ! TextUtils.isEmpty(pSSNText) && result3==0) {
                    result1 = myDataBase.setParentData(pName, pSSN, pMobile);
                    result2 = myDataBase.setStudentData(sName, sSSN, sHifz, sHalaqa, sMobile, pSSN);
                    result3=5;
                }else if(TextUtils.isEmpty(pName)){
                    parentName.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addNewStudent.this, " يجب إدخال اسم ولي الأمر ", Toast.LENGTH_LONG).show();
                    result3=-1;
                }else if(TextUtils.isEmpty(pSSNText)){
                    parentSSN.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addNewStudent.this, " يجب إدخال رقم هوية ولي الأمر ", Toast.LENGTH_LONG).show();
                    result3=-1;

                }else if(TextUtils.isEmpty(pMobile)){
                    parentMobile.setError("لايمكن لهذه الخانة ان تكون فارغة");
                    Toast.makeText(addNewStudent.this, " يجب إدخال رقم جوال ولي الأمر ", Toast.LENGTH_LONG).show();
                    result3=-1;
                }}
                if(result3 == 5){
                if (result1 == -1) {
                    Toast.makeText(addNewStudent.this, " ولي الامر موجود استخدم قائمة تسجيل (لديه أخ) ", Toast.LENGTH_SHORT).show();
                } else if (result2 == -1) {
                    Toast.makeText(addNewStudent.this, " الطالب موجود مسبقا  ", Toast.LENGTH_SHORT).show();
                } else {
                        Toast.makeText(addNewStudent.this, " تمت اضافة الطالب بنجاح ", Toast.LENGTH_SHORT).show();
                        refreshing();
                    }



                    }
                }
        }

    );
    }
    public void onParentExistButtonClick() {
        parentExist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parentName.getVisibility()==View.GONE && parentMobile.getVisibility()==View.GONE && parentSSN.getVisibility()==View.GONE) {

                    parentName.setVisibility(View.VISIBLE);
                    parentMobile.setVisibility(View.VISIBLE);
                    parentSSN.setVisibility(View.VISIBLE);

                } else {
                    parentName.setVisibility(View.GONE);
                    parentMobile.setVisibility(View.GONE);
                    parentSSN.setVisibility(View.GONE);
                }
            }
        });
    }



    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(4);
        if (lables.size() == 0){
            Toast.makeText(this,"لاتوجد حلقة مضافة يجب إضافة حلقة أولاً",Toast.LENGTH_SHORT).show();
            finish();
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        halaqaSpinner.setAdapter(dataAdapter);
    }

    public void refreshing (){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
