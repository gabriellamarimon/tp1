package com.example.parte1_atividade3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import java.lang.Math;
public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private SensorManager sm;
    private Sensor accelerometer;
    private float x,y,z;

    private TextView xText,yText,zText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xText = findViewById(R.id.xText);
        yText = findViewById(R.id.yText);
        zText = findViewById(R.id.zText);

        x = y = z = 0;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            float absX, absY, absZ;
            absX = Math.abs(x - event.values[0]);
            absY = Math.abs(y - event.values[1]);
            absZ = Math.abs(z - event.values[2]);

            if ( (  absX >= 0.1 && x != 0) || ( absY >= 0.1 && y != 0) || ( absZ >= 0.1 && x != 0) ){
                String message = "Phone has been moved";
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                intent.putExtra("Message",message);
                startActivity(intent);
            }
            else {
                x = event.values[0];
                y = event.values[1];
                z = event.values[2];

                xText.setText("X: " + x);
                yText.setText("Y: " + y);
                zText.setText("Z: " + z);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume() {
        super.onResume();
        sm = (SensorManager) getApplicationContext().getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onPause() {
        super.onPause();
        sm.unregisterListener(this, accelerometer);
    }
}