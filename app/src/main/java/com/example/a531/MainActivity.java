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


    Button RM_Calc, Next, Home_button;
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

        Next = findViewById(R.id.next_button);
        RM_Calc = findViewById(R.id.RM_Calc);

        enter_currentLifts();

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


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLifts.set_deadlift(Float.parseFloat(DL_TextBox.getText().toString()));
                currentLifts.set_squat(Float.parseFloat(Squat_TextBox.getText().toString()));
                currentLifts.set_OHP(Float.parseFloat(OHP_TextBox.getText().toString()));
                currentLifts.set_bench_press(Float.parseFloat(BP_TextBox.getText().toString()));

                saveData();
                startActivity(new Intent(MainActivity.this, HomePage.class));
            }
        });
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("newDL", currentLifts.get_deadlift());
        editor.putFloat("newSQ", currentLifts.get_squat());
        editor.putFloat("newBP", currentLifts.get_bench_press());
        editor.putFloat("newOHP", currentLifts.get_ohp());

        editor.apply();
    }

    private void enter_currentLifts() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        DL_TextBox.setText(String.valueOf(sharedPreferences.getFloat("newDL",0)));
        Squat_TextBox.setText(String.valueOf(sharedPreferences.getFloat("newSQ",0)));
        BP_TextBox.setText(String.valueOf(sharedPreferences.getFloat("newBP",0)));
        OHP_TextBox.setText(String.valueOf(sharedPreferences.getFloat("newOHP",0)));

    }

}
