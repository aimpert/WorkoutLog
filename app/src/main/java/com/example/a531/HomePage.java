package com.example.a531;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import android.widget.Button;

public class HomePage extends AppCompatActivity {

    TextView DL_Header, SQ_Header, BP_Header, OHP_Header;
    Button TM_Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        DL_Header = findViewById(R.id.DL_Header);
        SQ_Header = findViewById(R.id.SQ_Header);
        BP_Header = findViewById(R.id.BP_Header);
        OHP_Header = findViewById(R.id.OHP_Header);
        TM_Calc = findViewById(R.id.TM_Calc);

        TM_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, MainActivity.class));
            }
        });

        //DL_Header.setText(String.valueOf(currentLifts.get_deadlift()));
    }
}