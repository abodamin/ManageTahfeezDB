package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

import java.util.List;

public class addHalaqa extends AppCompatActivity {
    MyDataBase myDataBase = new MyDataBase(this);
    Spinner spinnerTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_halaqa);

        final EditText halaqaName = (EditText) findViewById(R.id.insertHalaqaName);
        final EditText halaqaCategory = (EditText) findViewById(R.id.insertHalaqaCategory);

        spinnerTeacher = (Spinner) findViewById(R.id.spinnerChooseTeacher);
        loadSpinnerData();

        Button btnInsertHalaqa = (Button) findViewById(R.id.btnInsertHalaqa);

        btnInsertHalaqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hTeacherSSN = Integer.parseInt(spinnerTeacher.getSelectedItem().toString());
                String hName = halaqaName.getText().toString().trim();
                String hCategory = halaqaCategory.getText().toString().trim();
                long result=0,result1=0;

                if(! TextUtils.isEmpty(hName) && ! TextUtils.isEmpty(hCategory) && result1==0){
                    result = myDataBase.setHalaqaData(hName, hCategory, hTeacherSSN);
                    result1 = 5;
                }
                else if(TextUtils.isEmpty(hName)) {
                    halaqaName.setError("يجب إدخال اسم الحلقة");
                    result1=-1;
                }
                else if(TextUtils.isEmpty(hCategory)){
                    halaqaCategory.setError("يجب إدخال تصنيف الحلقة");
                    result1=-1;
                }
                // If all good, will check if there's Query error on setting halaqa.
                if(result1==5) {
                    if (result == -1) {
                        Toast.makeText(addHalaqa.this, " خطأ في الادخال ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(addHalaqa.this, " تمت اضافة الحلقة بنجاح ", Toast.LENGTH_SHORT).show();
                        refreshing();
                    }
                }
            }
        });
    }

    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(3);
        if (lables.size() == 0){
            Toast.makeText(this,"لايوجد معلم مضاف أضف معلم أولاً",Toast.LENGTH_SHORT).show();
            finish();
        }
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerTeacher.setAdapter(dataAdapter);
    }
    public void refreshing (){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
