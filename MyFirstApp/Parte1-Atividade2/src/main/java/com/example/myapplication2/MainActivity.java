package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    private EditText enterMessage;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterMessage = findViewById(R.id.enterMessage);
        send = findViewById(R.id.send);

    }

    public void send(View view) {
        String message = enterMessage.getText().toString();
        Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
        intent.putExtra("Message",message);
        startActivity(intent);
    }
}