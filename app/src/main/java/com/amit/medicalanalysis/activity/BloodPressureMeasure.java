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

public class BloodPressureMeasure extends AppCompatActivity {

    public EditText lowBloodP, highBloodP, dateEdit;
    Button button;

    DatePickerDialog.OnDateSetListener setListener;
    private int year, month, day;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure_measure);

        //Calender
        Calendar calender = Calendar.getInstance();
        final int year = calender.get(Calendar.YEAR);
        final int month = calender.get(Calendar.MONTH);
        final int day = calender.get(Calendar.DAY_OF_MONTH);

        lowBloodP = findViewById(R.id.editText1);
        highBloodP = findViewById(R.id.editText2);
        dateEdit =(EditText) findViewById(R.id.editTextDate);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BloodPressureMeasure.this, "Will Add in the Database", Toast.LENGTH_SHORT).show();
            }
        });

        dateEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                DatePickerDialog datePickerDialog = new DatePickerDialog(BloodPressureMeasure.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
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
                dateEdit.setText(date);

            }
        };
    }
}