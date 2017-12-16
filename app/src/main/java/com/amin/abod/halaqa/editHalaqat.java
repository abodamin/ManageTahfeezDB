package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editHalaqat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_halaqat);
        final EditText UpdateHalaqaNameToUpdate = (EditText) findViewById(R.id.insertHalaqaNametoUpdate);
        final EditText UpdateHalaqaName = (EditText) findViewById(R.id.insertHalaqaName);
        final EditText insertUpdatedHalaqaTeacher = (EditText) findViewById(R.id.insertUpdatedHalaqaTeacher);

        Button btnUpdateHalaqa = (Button) findViewById(R.id.btnUpdateHalaqa);

        btnUpdateHalaqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newHalaqaName = UpdateHalaqaName.getText().toString().trim();
                String oldHalaqaName = UpdateHalaqaNameToUpdate.getText().toString().trim();
                String newTeacerName = insertUpdatedHalaqaTeacher.getText().toString().trim();

            }
        });




    }
}
