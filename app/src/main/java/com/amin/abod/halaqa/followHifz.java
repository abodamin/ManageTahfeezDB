package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.List;

import com.amin.abod.halaqa.Module.MyDataBase;

public class followHifz extends AppCompatActivity {
    Spinner studentSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_hifz);

        // Spinner element
        studentSpinner = (Spinner) findViewById(R.id.spinnerStudentList);

        loadSpinnerData();
    }

    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        studentSpinner.setAdapter(dataAdapter);
    }
}
