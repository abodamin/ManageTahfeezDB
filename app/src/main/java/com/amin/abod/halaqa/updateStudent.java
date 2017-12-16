package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.amin.abod.halaqa.Module.MyDataBase;

import java.util.List;

public class updateStudent extends AppCompatActivity {
    Spinner studentsSpinner;
    RadioButton nameRadioButton,mobileRadioButton,halaqaRadioButton;
    EditText studentName,studentMobile,studentHalaqa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        onBtnClick();
    }

    public void onBtnClick() {
        nameRadioButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                studentName.setVisibility((studentName.getVisibility() == View.GONE)
                        ? View.GONE : View.VISIBLE);

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
