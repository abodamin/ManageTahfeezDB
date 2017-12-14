package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class students extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        final Intent toFollowHifz = new Intent(students.this, followHifz.class);

        Button btnFollowHifz = (Button) findViewById(R.id.btnHifz);

        btnFollowHifz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toFollowHifz);
            }
        });
    }
}
