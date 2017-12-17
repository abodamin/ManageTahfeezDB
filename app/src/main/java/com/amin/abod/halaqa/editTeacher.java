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

public class editTeacher extends AppCompatActivity {
MyDataBase myDataBase = new MyDataBase(this);
    Spinner teacherUpdateSpinner; RadioButton radioEditTeacherName; RadioButton radioEditTeacherMobile;
    EditText insertUpdatedTeacherName; EditText insertUpdatedTeacherMobile;
    Button btnchangeTeacherInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_teacher);

        teacherUpdateSpinner = (Spinner) findViewById(R.id.spinnerTeacherUpdate);

        insertUpdatedTeacherName = (EditText) findViewById(R.id.insertUpdatedTeacherName);
        insertUpdatedTeacherName.setVisibility(View.GONE);

        insertUpdatedTeacherMobile = (EditText) findViewById(R.id.insertUpdatedTeacherMobile);
        insertUpdatedTeacherMobile.setVisibility(View.GONE);

        radioEditTeacherName = (RadioButton) findViewById(R.id.radioEditTeacherName);
        radioEditTeacherMobile = (RadioButton) findViewById(R.id.radioEditTeacherMobile);

        btnchangeTeacherInfo = (Button) findViewById(R.id.btnchangeTeacherInfo);

        loadSpinnerData();

        onTnameRadioButtonClick();
        onTmobileRadioButtonClick();

        btnchangeTeacherInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(insertUpdatedTeacherName.getVisibility() == View.VISIBLE){

                    String newTeacherName = insertUpdatedTeacherName.getText().toString().trim();
                    int tSSN = Integer.parseInt(teacherUpdateSpinner.getSelectedItem().toString());
                    if(TextUtils.isEmpty(newTeacherName)){
                        insertUpdatedTeacherName.setError("لايمكن لهذه الخانة ان تكون فارغة");
                        return;
                    }else{
                    boolean r = myDataBase.updateTeacherInfo(newTeacherName, tSSN , 1);

                    if (r) {
                        Toast.makeText(getApplicationContext(), " تم تعديل الاسم بنجاح ", Toast.LENGTH_SHORT).show();
                        refreshing();
                    } else {
                        Toast.makeText(getApplicationContext(), " يوجد خطأ ", Toast.LENGTH_SHORT).show();
                    }}


                }else if(insertUpdatedTeacherMobile.getVisibility() == View.VISIBLE) {

                        String newTeacherMobile = insertUpdatedTeacherMobile.getText().toString().trim();
                        int tSSN = Integer.parseInt(teacherUpdateSpinner.getSelectedItem().toString());
                        boolean r = myDataBase.updateTeacherInfo(newTeacherMobile, tSSN , 2);
                    if(TextUtils.isEmpty(newTeacherMobile)){
                        insertUpdatedTeacherMobile.setError("لايمكن لهذه الخانة ان تكون فارغة");
                        return;
                    }else{
                        if (r) {
                            Toast.makeText(getApplicationContext(), " تم تعديل الرقم بنجاح ", Toast.LENGTH_SHORT).show();
                            refreshing();
                        } else {
                            Toast.makeText(getApplicationContext(), " يوجد خطأ ", Toast.LENGTH_SHORT).show();
                        }}


                    }

                }

        });


    }

    public void refreshing (){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(3);//switch of teacher

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        teacherUpdateSpinner.setAdapter(dataAdapter);
    }

    public void onTnameRadioButtonClick() {
        radioEditTeacherName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (insertUpdatedTeacherName.getVisibility() == View.GONE) {

                     insertUpdatedTeacherName.setVisibility(View.VISIBLE);
                    insertUpdatedTeacherMobile.setVisibility(View.GONE);

                } else {
                    insertUpdatedTeacherName.setVisibility(View.GONE);
                }
            }
        });
    }
    public void onTmobileRadioButtonClick() {
        radioEditTeacherMobile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (insertUpdatedTeacherMobile.getVisibility() == View.GONE) {

                    insertUpdatedTeacherMobile.setVisibility(View.VISIBLE);
                    insertUpdatedTeacherName.setVisibility(View.GONE);

                } else {
                    insertUpdatedTeacherMobile.setVisibility(View.GONE);
                }
            }
        });
    }

}
