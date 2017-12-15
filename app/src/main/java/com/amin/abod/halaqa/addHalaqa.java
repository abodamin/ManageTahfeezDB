package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

public class addHalaqa extends AppCompatActivity {
    MyDataBase myDataBase = new MyDataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_halaqa);

        final EditText halaqaName = (EditText) findViewById(R.id.insertHalaqaName);
        final EditText halaqaCategory = (EditText) findViewById(R.id.insertHalaqaCategory);
        final EditText halaqaTeacherSSN = (EditText) findViewById(R.id.insertHalaqaTeacherSSN);

        Button btnInsertHalaqa = (Button) findViewById(R.id.btnInsertHalaqa);

        btnInsertHalaqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hTeacherSSN = Integer.parseInt(halaqaTeacherSSN.getText().toString().trim());
                String hName = halaqaName.getText().toString().trim();
                String hCategory = halaqaCategory.getText().toString().trim();
                long result = myDataBase.setHalaqaData(hName, hCategory, hTeacherSSN);

                if(result==-1){
                    Toast.makeText(addHalaqa.this, " Error occured ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(addHalaqa.this, " Added succefuly ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
