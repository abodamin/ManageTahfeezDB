package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class halaqat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaqat);

        final Intent toAddHalaqa = new Intent(halaqat.this,addHalaqa.class);
        Button btnAddHalaqa = (Button) findViewById(R.id.btnAddHalaqa);

        final Intent toViewHalaqat = new Intent(halaqat.this,viewHalaqat.class);
        Button btnShowHalaqat = (Button) findViewById(R.id.btnViewHalaqat);

        final Intent toEditHalaqat = new Intent(halaqat.this,editHalaqat.class);
        Button btnEditHalaqat = (Button) findViewById(R.id.btnEditHalaqat);


        btnAddHalaqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toAddHalaqa);
            }
        });

        btnShowHalaqat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toViewHalaqat);
            }
        });

        btnEditHalaqat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toEditHalaqat);
            }
        });
    }
}
