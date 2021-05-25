package com.amit.medicalanalysis.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amit.medicalanalysis.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private Button signup;
    private EditText mobNumber;
    private EditText password;
    private TextInputLayout textInputLayout1;
    private TextInputLayout textInputLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();

        login = findViewById(R.id.login);
        mobNumber = findViewById(R.id.mobNumber);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.button3);
        textInputLayout1 = findViewById(R.id.name_text_input1);
        textInputLayout2 = findViewById(R.id.name_text_input2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), SignUpActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), DashboardActivity.class);
                startActivity(i);

            }
        });
    }
}