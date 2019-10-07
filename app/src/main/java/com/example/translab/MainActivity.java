package com.example.translab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.DateSetListener{
    EditText etName,etEmail,etCompany,etPhNum,etContact;
    TextView textView;
    SqliteHelper sqliteHelper;
    DatePickerFragment datePickerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etCompany = findViewById(R.id.etCompany);
        etPhNum = findViewById(R.id.etPhNum);
        etContact = findViewById(R.id.etContact);

        sqliteHelper = new SqliteHelper(this);
        blink();
    }

    public void submit(View view) {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String company = etCompany.getText().toString();
        String phnNum = etPhNum.getText().toString();
        String contact = etContact.getText().toString();

        long rowId = sqliteHelper.insertDataIntoTable(name,email,company,phnNum,contact);

        if(rowId >0 ){

            Toast.makeText(this,"Data saved to Database Successfully",Toast.LENGTH_LONG).show();

            etName.setText("");
            etEmail.setText("");
            etCompany.setText("");
            etPhNum.setText("");
            etContact.setText("");
        }else {
            Toast.makeText(this,"Data not saved to Database",Toast.LENGTH_LONG).show();
        }
    }

    public void date(View view) {
        datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(),"date");

    }

    @Override
    public void listenDateChange(int year, int month, int day) {

    }
    public void blink(){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timetoblink = 1000;
                try {
                    Thread.sleep(timetoblink);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                     textView = findViewById(R.id.tvLogo);
                     if(textView.getVisibility() == View.VISIBLE){
                         textView.setVisibility(View.INVISIBLE);
                     }else {
                         textView.setVisibility(View.VISIBLE);
                     }
                     blink();
                    }
                });
            }
        }).start();
    }
}
