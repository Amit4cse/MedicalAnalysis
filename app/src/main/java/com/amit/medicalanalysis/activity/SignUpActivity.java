package com.amit.medicalanalysis.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.amit.medicalanalysis.R;

public class SignUpActivity extends AppCompatActivity {

    private Button signup, getOTP;
    private EditText name, mobNumber, password, age, weight, height, sex, city, otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup = findViewById(R.id.button);

        name = findViewById(R.id.editText);
        mobNumber = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
        age = findViewById(R.id.editText4);
        weight = findViewById(R.id.editText5);
        height = findViewById(R.id.editText6);
        sex = findViewById(R.id.editText7);
        city = findViewById(R.id.editText9);
    }
}