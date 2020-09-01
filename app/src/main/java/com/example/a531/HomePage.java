package com.example.a531;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import android.widget.Button;


public class HomePage extends AppCompatActivity {

    TextView DL_Header, SQ_Header, BP_Header, OHP_Header;
    Button Edit_button;
    lifts currentLifts = new lifts(0, 0, 0, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        checkFirstLaunch();


        DL_Header = findViewById(R.id.DL_Header);
        SQ_Header = findViewById(R.id.SQ_Header);
        BP_Header = findViewById(R.id.BP_Header);
        OHP_Header = findViewById(R.id.OHP_Header);
        Edit_button = findViewById(R.id.Edit_button);
        loadData();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, MainActivity.class));
            }
        });

        DL_Header.setText("Deadlift: "+String.valueOf(currentLifts.get_deadlift()));
        SQ_Header.setText("Squat: "+String.valueOf(currentLifts.get_squat()));
        OHP_Header.setText("Overhead Press: "+String.valueOf(currentLifts.get_ohp()));
        BP_Header.setText("Bench Press "+String.valueOf(currentLifts.get_bench_press()));
    }



    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        currentLifts.set_deadlift(sharedPreferences.getFloat("newDL",0));
        currentLifts.set_squat(sharedPreferences.getFloat("newSQ",0));
        currentLifts.set_bench_press(sharedPreferences.getFloat("newBP",0));
        currentLifts.set_OHP(sharedPreferences.getFloat("newOHP",0));

    }


    private void checkFirstLaunch() {
        final String version_key = "version_key";
        final int firstRun = -1;

        int currentVersion = BuildConfig.VERSION_CODE;
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        int savedVersion = sharedPreferences.getInt(version_key, firstRun);

        if (currentVersion == savedVersion) {
            return;
        }
        else if (savedVersion == firstRun) {
            startActivity(new Intent(HomePage.this, MainActivity.class));
        }

        else if (currentVersion > savedVersion) {
            return; // for future upgrades
        }

        sharedPreferences.edit().putInt(version_key, currentVersion).apply();
        }

}