package com.example.mapscanactuallygodye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class InfoScreen extends AppCompatActivity {

    public String park;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);

        Intent intent = getIntent();
        park = intent.getStringExtra("PARK");

        TextView parkName = (TextView) findViewById(R.id.parkName);
        parkName.setText(park);
    }
}
