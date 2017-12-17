package com.amin.abod.halaqa;

import android.content.Intent;
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

public class editHalaqat extends AppCompatActivity {
    MyDataBase myDataBase = new MyDataBase(this);
    EditText newHalaqaName ;
    Spinner spinnerHalaqaToUpdate;
    Spinner spinnerNewTeacher;
    Button btnUpdateHalaqa;
    RadioButton radioEditHalaqaName;
    RadioButton radioEditHalaqaTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        btnUpdateHalaqa = (Button) findViewById(R.id.btnchangeHalaqaInfo);
        setContentView(R.layout.activity_edit_halaqat);

        radioEditHalaqaName = (RadioButton) findViewById(R.id.radioEditHalaqaName);
        newHalaqaName = (EditText) findViewById(R.id.insertNewHalaqaName);
        newHalaqaName.setVisibility(View.GONE);

        radioEditHalaqaTeacher  = (RadioButton) findViewById(R.id.radioEditHalaqaTeacher);
        spinnerNewTeacher = (Spinner) findViewById(R.id.spinnerNewHalaqaTeacher);
        spinnerNewTeacher.setVisibility(View.GONE);

        /*Choose Halaqah spinner*/
        spinnerHalaqaToUpdate = (Spinner) findViewById(R.id.spinnerHalaqaToUpdate);// always on





        loadHalaqaNameSpinner();

        onHalaqaNameRadioButtonClick();
        onHalaqaTeacherRadioButtonClick();

        loadHalaqaTeacherSpinner();
        Button btnUpdateHalaqa = (Button) findViewById(R.id.btnchangeHalaqaInfo);
        btnUpdateHalaqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerNewTeacher.getVisibility() == View.VISIBLE){
                    int newHalaqaTeacher = Integer.parseInt(spinnerNewTeacher.getSelectedItem().toString());
                    String hName = spinnerHalaqaToUpdate.getSelectedItem().toString().trim();
                    boolean r = myDataBase.updateHalaqaTeacherInfo(newHalaqaTeacher,hName);
                    if(r){
                        Toast.makeText(editHalaqat.this, "تم تعديل المعلم بنجاح", Toast.LENGTH_SHORT).show();
                        refreshing ();
                    }else{
                        Toast.makeText(editHalaqat.this, "هناك خطأ !", Toast.LENGTH_SHORT).show();
                    }
                }else if(newHalaqaName.getVisibility() ==  View.VISIBLE){
                    String nHname = newHalaqaName.getText().toString().trim();
                    String oldHname = spinnerHalaqaToUpdate.getSelectedItem().toString().trim();
                    boolean r = myDataBase.updateHalaqaNameInfo(nHname ,oldHname);
                    if(r){
                        Toast.makeText(editHalaqat.this, "تم تعديل الحقلة بنجاح", Toast.LENGTH_SHORT).show();
                        refreshing ();
                    }else{
                        Toast.makeText(editHalaqat.this, "هناك خطأ !", Toast.LENGTH_SHORT).show();
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

    public void onHalaqaNameRadioButtonClick() {
        radioEditHalaqaName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (newHalaqaName.getVisibility() == View.GONE) {

                    newHalaqaName.setVisibility(View.VISIBLE);
                    spinnerNewTeacher.setVisibility(View.GONE);

                } else {
                    newHalaqaName.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onHalaqaTeacherRadioButtonClick() {
        radioEditHalaqaTeacher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (spinnerNewTeacher.getVisibility() == View.GONE) {

                    spinnerNewTeacher.setVisibility(View.VISIBLE);
                    newHalaqaName.setVisibility(View.GONE);

                } else {
                    spinnerNewTeacher.setVisibility(View.GONE);
                }
            }
        });
    }
    private void loadHalaqaNameSpinner() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(4); // Halaqat

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerHalaqaToUpdate.setAdapter(dataAdapter);
    }

    private void loadHalaqaTeacherSpinner() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(3); // Teachers

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerNewTeacher.setAdapter(dataAdapter);
    }

}
