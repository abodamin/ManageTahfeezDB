package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

import java.util.List;

public class deleteStudent extends AppCompatActivity {

    Spinner studentSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        final MyDataBase myDataBase = new MyDataBase(getApplicationContext());

        studentSpinner = (Spinner) findViewById(R.id.spinnerStudentList);
        loadSpinnerData();

        Button btnDeleteStudentD = (Button) findViewById(R.id.btnDeleteStudentD);

        btnDeleteStudentD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SSN = studentSpinner.getSelectedItem().toString().trim();
                Integer result = myDataBase.deleteStudent(SSN);

                if (result >0 ){
                    Toast.makeText(deleteStudent.this, " تم حذف الطالب ", Toast.LENGTH_SHORT).show();
                    refreshing();
                } else {
                    Toast.makeText(deleteStudent.this, " خطأ ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(5);
        if (lables.size() == 0){
            Toast.makeText(this,"لايوجد طلاب مضافين",Toast.LENGTH_SHORT).show();
            finish();
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        studentSpinner.setAdapter(dataAdapter);
    }
    public void refreshing (){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
