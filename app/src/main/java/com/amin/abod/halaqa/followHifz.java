package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import com.amin.abod.halaqa.Module.MyDataBase;

public class followHifz extends AppCompatActivity {
    Spinner studentSpinner; MyDataBase myDataBase = new MyDataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_hifz);

        final EditText hifzSoura = (EditText) findViewById(R.id.insertHifzSourah);
        final EditText hifzAya = (EditText) findViewById(R.id.insertHifzAyah);
        Button btnUpdateHifz = (Button) findViewById(R.id.btnUpdeteHifz);

        // Spinner element
        studentSpinner = (Spinner) findViewById(R.id.spinnerStudentList);

        loadSpinnerData();

        btnUpdateHifz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String soura = hifzSoura.getText().toString().trim();
                int Aya = Integer.parseInt(hifzAya.getText().toString().trim());
                int sID = Integer.parseInt(studentSpinner.getSelectedItem().toString());
                soura += String.valueOf("("+Aya+")");
                boolean r = myDataBase.updateStudentHifz(soura , sID);

                if(r){
                    Toast.makeText(followHifz.this, " Added succefuly ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(followHifz.this, " Error occured ", Toast.LENGTH_SHORT).show();
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
        studentSpinner.setAdapter(dataAdapter);
    }
}
