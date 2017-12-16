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

public class updateStudent extends AppCompatActivity {
    MyDataBase myDataBase = new MyDataBase(this);
    Spinner studentsSpinner;
    Button btnUpdateStudentInfo;
    RadioButton nameRadioButton, mobileRadioButton, halaqaRadioButton;
    EditText studentName, studentMobile;
    Spinner studentHalaqa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnUpdateStudentInfo = (Button) findViewById(R.id.btnUpdateStudentInfo);
        setContentView(R.layout.activity_update_student);

        nameRadioButton = (RadioButton) findViewById(R.id.radioEditName);
        studentName = (EditText) findViewById(R.id.insertUpdatedStudentName);
        studentName.setVisibility(View.GONE);
        mobileRadioButton = (RadioButton) findViewById(R.id.radioEditMobile);
        studentMobile = (EditText) findViewById(R.id.insertUpdatedStudentMobile);
        studentMobile.setVisibility(View.GONE);
        halaqaRadioButton = (RadioButton) findViewById(R.id.radioEditHalaqa);
        studentHalaqa = (Spinner) findViewById(R.id.spinnerHalaqaList);
        studentHalaqa.setVisibility(View.GONE);
        // Spinner element
        studentsSpinner = (Spinner) findViewById(R.id.spinnerStudentList);

        loadSpinnerData();
        onNameRadioButtonClick();
        onMobileRadioButtonClick();
        onHalaqaRadioButtonClick();
        loadSpinnerHalaqa();

        Button btnUpdateStudentInfo = (Button) findViewById(R.id.btnUpdateStudentInfo);

        btnUpdateStudentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentName.getVisibility() == View.VISIBLE) {

                    String sName = studentName.getText().toString().trim();
                    int SSN = Integer.parseInt(studentsSpinner.getSelectedItem().toString());
                    if (TextUtils.isEmpty(sName)) {
                        studentName.setError("لايمكن لهذه الخانة ان تكون فارغة");
                        return;
                    } else {
                        boolean r = myDataBase.updateStudentInfo(sName, SSN, 1);
                        if (r) {
                            Toast.makeText(updateStudent.this, " تم تعديل الاسم بنجاح ", Toast.LENGTH_SHORT).show();
                            refreshing ();
                        } else {
                            Toast.makeText(updateStudent.this, " يوجد خطأ ", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else if (studentMobile.getVisibility() == View.VISIBLE) {
                    String sMobile = studentMobile.getText().toString().trim();
                    int SSN = Integer.parseInt(studentsSpinner.getSelectedItem().toString());
                    if (TextUtils.isEmpty(sMobile)) {
                        studentMobile.setError("لايمكن لهذه الخانة ان تكون فارغة");
                        return;
                    } else {
                    boolean r = myDataBase.updateStudentInfo(sMobile, SSN, 2);

                    if (r) {
                        Toast.makeText(updateStudent.this, " تم تعديل رقم الجوال بنجاح ", Toast.LENGTH_SHORT).show();
                        refreshing ();
                    } else {
                        Toast.makeText(updateStudent.this, " يوجد خطأ ", Toast.LENGTH_SHORT).show();
                    }   }
                } else if (studentHalaqa.getVisibility() == View.VISIBLE) {
                    String sNewHalaqa = studentHalaqa.getSelectedItem().toString().trim();
                    int SSN = Integer.parseInt(studentsSpinner.getSelectedItem().toString());

                    boolean r = myDataBase.updateStudentInfo(sNewHalaqa, SSN, 3);

                    if (r) {
                        Toast.makeText(updateStudent.this, "تم نقل الطالب الى الحلقة الجديد بنجاح ", Toast.LENGTH_SHORT).show();
                        refreshing ();
                    } else {
                        Toast.makeText(updateStudent.this, " يوجد خطأ ", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }

    public void onNameRadioButtonClick() {
        nameRadioButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (studentName.getVisibility() == View.GONE) {
                    studentName.setVisibility(View.VISIBLE);
                    studentHalaqa.setVisibility(View.GONE);
                    studentMobile.setVisibility(View.GONE);
                } else {
                    studentName.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onMobileRadioButtonClick() {
        mobileRadioButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (studentMobile.getVisibility() == View.GONE) {
                    studentMobile.setVisibility(View.VISIBLE);
                    studentHalaqa.setVisibility(View.GONE);
                    studentName.setVisibility(View.GONE);
                } else {
                    studentMobile.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onHalaqaRadioButtonClick() {
        halaqaRadioButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (studentHalaqa.getVisibility() == View.GONE) {
                    studentHalaqa.setVisibility(View.VISIBLE);
                    studentName.setVisibility(View.GONE);
                    studentMobile.setVisibility(View.GONE);
                } else {
                    studentHalaqa.setVisibility(View.GONE);
                }
            }
        });
    }

    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(5);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        studentsSpinner.setAdapter(dataAdapter);
    }

    private void loadSpinnerHalaqa() {
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
        studentHalaqa.setAdapter(dataAdapter);
    }

    public void refreshing (){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
