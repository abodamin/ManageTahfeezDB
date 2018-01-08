package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

import java.util.ArrayList;

public class viewTeachers extends AppCompatActivity {
    ListView listView;

    MyDataBase myDataBase = new MyDataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teachers);
        listView  = (ListView) findViewById(R.id.listViewData);
        showData();


    }

    private void showData() {
        ArrayList<String> list = myDataBase.getAllTeachers();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        if(arrayAdapter.isEmpty() == true) {
            Toast.makeText(this, "لا يوجد معلمين لعرضهم", Toast.LENGTH_LONG).show();
            finish();
        }
        listView.setAdapter(arrayAdapter);

    }
}
