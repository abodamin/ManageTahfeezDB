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

public class deleteHalaqa extends AppCompatActivity {

    Spinner spinnerHalaqaToDelete ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_halaqa);
        final MyDataBase myDataBase = new MyDataBase(getApplicationContext());

        spinnerHalaqaToDelete = (Spinner) findViewById(R.id.spinnerHalaqaToDelete);
        loadSpinnerData();
        Button btnDeleteHalaqaD = (Button) findViewById(R.id.btnDeleteHalaqaD);
        btnDeleteHalaqaD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String hName = spinnerHalaqaToDelete.getSelectedItem().toString().trim();
                boolean result = myDataBase.deleteHalaqa(hName);

                if (result){
                    Toast.makeText(deleteHalaqa.this, " تم حذف الحلقة ", Toast.LENGTH_SHORT).show();
                    refreshing();
                } else {
                    Toast.makeText(deleteHalaqa.this, " خطأ ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(4);
        if (lables.size() == 0){
            Toast.makeText(this,"لاتوجد حلقة مضافة",Toast.LENGTH_SHORT).show();
            finish();
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerHalaqaToDelete.setAdapter(dataAdapter);
    }

    public void refreshing (){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
