package com.example.a531;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import android.widget.Button;


public class HomePage extends AppCompatActivity {

    TextView DL_Header, SQ_Header, BP_Header, OHP_Header;
    Button TM_Calc;
    lifts currentLifts = new lifts(0, 0, 0, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        DL_Header = findViewById(R.id.DL_Header);
        SQ_Header = findViewById(R.id.SQ_Header);
        BP_Header = findViewById(R.id.BP_Header);
        OHP_Header = findViewById(R.id.OHP_Header);
        TM_Calc = findViewById(R.id.TM_Calc);
        loadData();

        TM_Calc.setOnClickListener(new View.OnClickListener() {
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
        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        currentLifts.set_deadlift(sharedPrefs.getFloat("newDL",0));
        currentLifts.set_squat(sharedPrefs.getFloat("newSQ",0));
        currentLifts.set_bench_press(sharedPrefs.getFloat("newBP",0));
        currentLifts.set_OHP(sharedPrefs.getFloat("newOHP",0));

    }

}