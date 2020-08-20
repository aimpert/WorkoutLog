package com.example.a531;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;

import android.widget.Button;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREFS = "sharedPrefs";


    EditText DL_TextBox;
    EditText Squat_TextBox;
    EditText BP_TextBox;
    EditText OHP_TextBox;
    TextView DLTM_View, STM_View, BPTM_View, OHP_View, TMs_View, DLTM, STM, BPTM, OHPTM;


    Button Submit, RM_Calc, Next;
    lifts currentLifts = new lifts(0, 0, 0, 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DL_TextBox = findViewById(R.id.DL_TextBox);
        Squat_TextBox = findViewById(R.id.Squat_TextBox);
        BP_TextBox = findViewById(R.id.BP_TextBox);
        OHP_TextBox = findViewById(R.id.OHP_TextBox);

        DLTM_View = findViewById(R.id.DLTM_View);
        STM_View = findViewById(R.id.STM_View);
        BPTM_View = findViewById(R.id.BPTM_View);
        OHP_View = findViewById(R.id.OHPTM_View);
        TMs_View = findViewById(R.id.TMs_View);
        DLTM = findViewById(R.id.DLTM);
        STM = findViewById(R.id.STM);
        BPTM = findViewById(R.id.BPTM);
        OHPTM = findViewById(R.id.OHPTM);

        Submit = findViewById(R.id.submit_button);
        Next = findViewById(R.id.next_button);
        RM_Calc = findViewById(R.id.RM_Calc);
        RM_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,rmPop.class));
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TMs_View.setVisibility(View.VISIBLE);
                DLTM.setVisibility(View.VISIBLE);
                STM.setVisibility(View.VISIBLE);
                BPTM.setVisibility(View.VISIBLE);
                OHPTM.setVisibility(View.VISIBLE);
                DLTM_View.setVisibility(View.VISIBLE);
                STM_View.setVisibility(View.VISIBLE);
                BPTM_View.setVisibility(View.VISIBLE);
                OHP_View.setVisibility(View.VISIBLE);

                currentLifts.set_deadlift(Float.valueOf(DL_TextBox.getText().toString()));
                currentLifts.set_squat(Float.valueOf(Squat_TextBox.getText().toString()));
                currentLifts.set_bench_press(Float.valueOf(BP_TextBox.getText().toString()));
                currentLifts.set_OHP(Float.valueOf(OHP_TextBox.getText().toString()));
                DLTM_View.setText(String.valueOf(currentLifts.get_deadliftTM()));
                STM_View.setText(String.valueOf(currentLifts.get_squatTM()));
                BPTM_View.setText(String.valueOf(currentLifts.get_BPTM()));
                OHP_View.setText(String.valueOf(currentLifts.get_ohp()));
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
