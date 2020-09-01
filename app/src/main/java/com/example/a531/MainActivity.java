package com.example.a531;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.EditText;

import android.widget.Button;

import android.widget.TextView;

import android.widget.GridView;


public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREFS = "sharedPrefs";


    EditText DL_TextBox;
    EditText Squat_TextBox;
    EditText BP_TextBox;
    EditText OHP_TextBox;
    GridView gridView;


    Button Submit, RM_Calc, Next, Home_button;
    lifts currentLifts = new lifts(0, 0, 0, 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("WORKOUTLOG", "MAIN created");

        //gridView = findViewById(R.id.gridView);

        DL_TextBox = findViewById(R.id.DL_TextBox);
        Squat_TextBox = findViewById(R.id.Squat_TextBox);
        BP_TextBox = findViewById(R.id.BP_TextBox);
        OHP_TextBox = findViewById(R.id.OHP_TextBox);

        Home_button = findViewById(R.id.Home_button);

        Submit = findViewById(R.id.submit_button);
        Next = findViewById(R.id.next_button);
        RM_Calc = findViewById(R.id.RM_Calc);
        RM_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,rmPop.class));
            }
        });

        Home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomePage.class));
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentLifts.set_deadlift(Float.valueOf(DL_TextBox.getText().toString()));
                currentLifts.set_squat(Float.valueOf(Squat_TextBox.getText().toString()));
                currentLifts.set_bench_press(Float.valueOf(BP_TextBox.getText().toString()));
                currentLifts.set_OHP(Float.valueOf(OHP_TextBox.getText().toString()));

                saveData();


            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomePage.class));
            }
        });
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("newDL", currentLifts.get_deadlift());
        editor.putFloat("newSQ", currentLifts.get_squat());
        editor.putFloat("newBP", currentLifts.get_bench_press());
        editor.putFloat("newOHP", currentLifts.get_ohp());

        editor.apply();
    }


}
