package com.example.parte2_atividade1e2;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sm;
    private Sensor light, temperature;

    private TextView lightIntensityText, ambientTemperatureText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightIntensityText = findViewById(R.id.lightIntensityText);
        ambientTemperatureText = findViewById(R.id.ambientTemperatureText);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_LIGHT) {
            lightIntensityText.setText("Light intensity: " + event.values[0]);
        } else if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            ambientTemperatureText.setText("Ambient temperature: " + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume() {
        super.onResume();
        sm = (SensorManager) getApplicationContext().getSystemService(SENSOR_SERVICE);

        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,light,SensorManager.SENSOR_DELAY_FASTEST);

        temperature = sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sm.registerListener(this,temperature,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onPause() {
        super.onPause();
        sm.unregisterListener(this, light);
        sm.unregisterListener(this, temperature);
    }
}