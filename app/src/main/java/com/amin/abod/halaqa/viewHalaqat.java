package com.amin.abod.halaqa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amin.abod.halaqa.Module.MyDataBase;

import java.util.ArrayList;

public class viewHalaqat extends AppCompatActivity {

    ListView listViewHalaqa ;

    MyDataBase myDataBase =  new MyDataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_halaqat);

        listViewHalaqa = (ListView) findViewById(R.id.listViewHalaqa);

        showDataHalaqa();
    }


    private void showDataHalaqa (){

        ArrayList<String> listHalaqa = myDataBase.getAllHalaqa();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listHalaqa);
        listViewHalaqa.setAdapter(arrayAdapter);

    }
}
