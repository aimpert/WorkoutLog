package com.example.a531;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

import android.util.Log;
import android.view.View;

import android.widget.EditText;

import android.widget.Button;

import android.widget.TextView;

public class rmPop extends AppCompatActivity {

    EditText weightEdit, repsEdit;
    TextView ORM_Result, ORM_View;
    Button calc_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rm_pop);
        Log.d("WORKOUTLOG", "popup created");
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;


        getWindow().setLayout((int) (width * 0.80 ), (int) (height * 0.50));

        weightEdit = findViewById(R.id.weightEdit);
        repsEdit = findViewById(R.id.repsEdit);
        ORM_Result = findViewById(R.id.ORM_Result);
        ORM_View = findViewById(R.id.ORM_View);
        calc_button = findViewById(R.id.calc_button);

        calc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float weightPerformed = Float.valueOf(weightEdit.getText().toString());
                float repsPerformed = Float.valueOf(repsEdit.getText().toString());

                float bryzcki = weightPerformed * (1 + (repsPerformed/30));
                ORM_Result.setText(String.valueOf(bryzcki));
                ORM_View.setVisibility(View.VISIBLE);
                ORM_Result.setVisibility(View.VISIBLE);

            }
        });



    }
}
