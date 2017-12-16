package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

import java.util.List;

public class deleteTeacher extends AppCompatActivity {

    Spinner spinnerTeacherToDelete ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_delete_teacher);
        final MyDataBase myDataBase = new MyDataBase(getApplicationContext());

        spinnerTeacherToDelete = (Spinner) findViewById(R.id.spinnerchooseTeacherToDelete);
        loadSpinnerData();
        Button btnDeleteTeacherD = (Button) findViewById(R.id.btnDeleteTeacherD);
        btnDeleteTeacherD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String tSSN = spinnerTeacherToDelete.getSelectedItem().toString().trim();
                Integer result = myDataBase.deleteTeacher(tSSN);

                if (result >0 ){
                    Toast.makeText(deleteTeacher.this, " Deleted ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(deleteTeacher.this, " Error ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(3);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerTeacherToDelete.setAdapter(dataAdapter);
    }
}
