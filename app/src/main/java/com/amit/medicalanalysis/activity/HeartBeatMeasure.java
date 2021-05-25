package com.amit.medicalanalysis.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amit.medicalanalysis.R;

import java.util.Calendar;

public class HeartBeatMeasure extends AppCompatActivity {

    EditText heartDate, heartCount;
    Button heartAdd;

    DatePickerDialog.OnDateSetListener setListener;
    private int year, month, day;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_beat_measure);

        //Calender
        Calendar calender = Calendar.getInstance();
        final int year = calender.get(Calendar.YEAR);
        final int month = calender.get(Calendar.MONTH);
        final int day = calender.get(Calendar.DAY_OF_MONTH);

        heartDate = findViewById(R.id.editTextHeartDate);
        heartCount = findViewById(R.id.editTextHeartCount);
        heartAdd = findViewById(R.id.buttonHeart);

        heartAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HeartBeatMeasure.this, "Will Add in the Database", Toast.LENGTH_SHORT).show();
            }
        });

        heartDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                DatePickerDialog datePickerDialog = new DatePickerDialog(HeartBeatMeasure.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();



            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1  = i1 + 1;
                String date = i2+"/"+i1+"/"+i;
                heartDate.setText(date);

            }
        };

    }
}