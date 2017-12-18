package com.amin.abod.halaqa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.amin.abod.halaqa.Module.MyDataBase;

import java.util.List;



public class updateParentInfo extends AppCompatActivity {

    MyDataBase myDataBase = new MyDataBase(this);
    Spinner parentUpdateSpinner;
    Button btnchangeParentInfo;
    RadioButton radioEditParentSSN,radioEditParentName,radioEditParentMobile;
    EditText updateParentSSN,updateParentName,updateParentMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_parent_info);
        btnchangeParentInfo = (Button) findViewById(R.id.btnchangeParentInfo);
        //update SSN of Parent

        radioEditParentSSN = (RadioButton) findViewById(R.id.radioEditParentSSN);
        updateParentSSN = (EditText) findViewById(R.id.insertUpdatedParentSSN);
        updateParentSSN.setVisibility(View.GONE);
        //update name of Parent
        radioEditParentName = (RadioButton) findViewById(R.id.radioEditParentName);
        updateParentName = (EditText) findViewById(R.id.insertUpdatedParentName);
        updateParentName.setVisibility(View.GONE);
        //update Parent Mobile
        radioEditParentMobile = (RadioButton) findViewById(R.id.radioEditParentMobile);
        updateParentMobile = (EditText) findViewById(R.id.insertUpdatedParentMobile);
        updateParentMobile.setVisibility(View.GONE);

        // Spinner element
        parentUpdateSpinner = (Spinner) findViewById(R.id.spinnerParentUpdate);

        loadSpinnerData();

        onSSNRadioButtonClick();
        onNameRadioButtonClick();
        onMobileRadioButtonClick();

        btnchangeParentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(updateParentSSN.getVisibility() == View.VISIBLE) {

                    String pSSNnew = updateParentSSN.getText().toString().trim();
                    int pSSNold = Integer.parseInt(parentUpdateSpinner.getSelectedItem().toString());
                    if(TextUtils.isEmpty(pSSNnew)) {
                        updateParentSSN.setError("لايمكن لهذه الخانة ان تكون فارغة");
                        return;
                    }else{
                    boolean r = myDataBase.updateParentInfoFun(pSSNnew, pSSNold,1);

                    if (r) {
                        Toast.makeText(updateParentInfo.this, " تم تعديل رقم  الهوية بنجاح ", Toast.LENGTH_SHORT).show();
                        refreshing();
                    } else {
                        Toast.makeText(updateParentInfo.this, " يوجد خطأ ", Toast.LENGTH_SHORT).show();
                    }
                }}else if(updateParentName.getVisibility() == View.VISIBLE) {

                    String pName = updateParentName.getText().toString().trim();
                    int pSSN = Integer.parseInt(parentUpdateSpinner.getSelectedItem().toString());
                        if(TextUtils.isEmpty(pName)){
                            updateParentName.setError("لايمكن لهذه الخانة ان تكون فارغة");
                            return;
                        }else{
                            boolean r = myDataBase.updateParentInfoFun(pName, pSSN,2);
                            if (r) {
                                Toast.makeText(updateParentInfo.this, " تم تعديل الاسم بنجاح ", Toast.LENGTH_SHORT).show();
                                refreshing();
                            } else {
                                Toast.makeText(updateParentInfo.this, " يوجد خطأ ", Toast.LENGTH_SHORT).show();
                            }
                        }

                }else if(updateParentMobile.getVisibility() == View.VISIBLE){
                    String pMobile = updateParentMobile.getText().toString().trim();
                    int pSSN = Integer.parseInt(parentUpdateSpinner.getSelectedItem().toString());
                    if(TextUtils.isEmpty(pMobile)){
                        updateParentMobile.setError("لايمكن لهذه الخانة ان تكون فارغة");
                        return;
                    }else {

                        boolean r = myDataBase.updateParentInfoFun(pMobile, pSSN, 3);

                        if (r) {
                            Toast.makeText(updateParentInfo.this, " تم تعديل رقم الجوال بنجاح ", Toast.LENGTH_SHORT).show();
                            refreshing();
                        } else {
                            Toast.makeText(updateParentInfo.this, " يوجد خطأ ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    private void loadSpinnerData() {
        // database handler
        MyDataBase db = new MyDataBase(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels(2);
        if (lables.size() == 0){
            Toast.makeText(this,"لايوجد ولي أمر مضاف",Toast.LENGTH_SHORT).show();
            finish();
        }
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        parentUpdateSpinner.setAdapter(dataAdapter);
    }

    public void onSSNRadioButtonClick() {
        radioEditParentSSN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (updateParentSSN.getVisibility() == View.GONE) {
                    updateParentSSN.setVisibility(View.VISIBLE);
                    updateParentName.setVisibility(View.GONE);
                    updateParentMobile.setVisibility(View.GONE);
                } else {
                    updateParentSSN.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onNameRadioButtonClick() {
        radioEditParentName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (updateParentName.getVisibility() == View.GONE) {
                    updateParentName.setVisibility(View.VISIBLE);
                    updateParentSSN.setVisibility(View.GONE);
                    updateParentMobile.setVisibility(View.GONE);
                } else {
                    updateParentName.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onMobileRadioButtonClick() {
        radioEditParentMobile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (updateParentMobile.getVisibility() == View.GONE) {
                    updateParentMobile.setVisibility(View.VISIBLE);
                    updateParentSSN.setVisibility(View.GONE);
                    updateParentName.setVisibility(View.GONE);
                } else {
                    updateParentMobile.setVisibility(View.GONE);
                }
            }
        });
    }
    public void refreshing (){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}


