package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    RadioButton nameRadioButton,mobileRadioButton,halaqaRadioButton;
    EditText studentName,studentMobile,studentHalaqa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnUpdateStudentInfo = (Button) findViewById(R.id.btnUpdateStudentInfo);

        setContentView(R.layout.activity_update_student);
        nameRadioButton = (RadioButton) findViewById(R.id.radioEditName);
        studentName = (EditText) findViewById(R.id.insertUpdatedStudentName);
        studentName.setVisibility(View.GONE);
        mobileRadioButton = (RadioButton) findViewById(R.id.radioEditMobile);
        studentMobile = (EditText) findViewById(R.id.insertUpdatedStudentMobile);
        studentMobile.setVisibility(View.GONE);
        halaqaRadioButton = (RadioButton) findViewById(R.id.radioEditHalaqa);
        studentHalaqa = (EditText) findViewById(R.id.insertUpdatedStudentHalaqa);
        studentHalaqa.setVisibility(View.GONE);
        // Spinner element
        studentsSpinner = (Spinner) findViewById(R.id.spinnerStudentList);

        loadSpinnerData();
        onNameRadioButtonClick();
        onMobileRadioButtonClick();
        onHalaqaRadioButtonClick();

        btnUpdateStudentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sName = studentName.getText().toString().trim();
                int SSN = Integer.parseInt(studentsSpinner.getSelectedItem().toString());

                boolean r = myDataBase.updateStudentHifz(sName , SSN);

                if(r){
                    Toast.makeText(updateStudent.this, " Added succefuly ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(updateStudent.this, " Error occured ", Toast.LENGTH_SHORT).show();
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
                if (studentHalaqa.getVisibility()== View.GONE){
                    studentHalaqa.setVisibility(View.VISIBLE);
                    studentName.setVisibility(View.GONE);
                    studentMobile.setVisibility(View.GONE);
                }else{
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
}
