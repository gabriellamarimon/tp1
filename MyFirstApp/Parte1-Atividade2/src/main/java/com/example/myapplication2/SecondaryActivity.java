package com.example.myapplication2;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    public TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        message = findViewById(R.id.message);

        message.setText(getIntent().getStringExtra("Message"));
    }
}