package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class management extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        final Intent toDeleteStudent = new Intent(management.this,deleteStudent.class);
        Button btnDeleteStudent = (Button) findViewById(R.id.btnDeleteStudent);

        final Intent toDeleteTeacher = new Intent(management.this,deleteTeacher.class);
        Button btnDeleteTeacher = (Button) findViewById(R.id.btnDeleteTeacher);

        final Intent toDeleteHalaqa = new Intent(management.this,deleteHalaqa.class);
        Button btnDeleteHalaqa = (Button) findViewById(R.id.btnDeleteHalaqa);

        final Intent toUpdateParentInfo = new Intent(management.this,updateParentInfo.class);
        Button btnUpdateParentInfo = (Button) findViewById(R.id.btnUpdateParentInfo);


        btnDeleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toDeleteStudent);
            }
        });

        btnDeleteTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toDeleteTeacher);
            }
        });

        btnDeleteHalaqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toDeleteHalaqa);
            }
        });

        btnUpdateParentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toUpdateParentInfo);
            }
        });
    }

}
