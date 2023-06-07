package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber, secondNumber;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.firstNumber);

        secondNumber = findViewById(R.id.secondNumber);

        result = findViewById(R.id.Result);
    }

    public void sum(View view) {

        int n1, n2;

        if (TextUtils.isEmpty(firstNumber.getText()))
            n1 = 0;
        else
            n1 = Integer.parseInt(firstNumber.getText().toString());

        if (TextUtils.isEmpty(secondNumber.getText()))
            n2 = 0;
        else
            n2 = Integer.parseInt(secondNumber.getText().toString());

        int total = n1 + n2;

        result.setText(String.valueOf(total));
    }

}