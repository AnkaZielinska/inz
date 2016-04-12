package com.example.maciej.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CalculateActivity extends AppCompatActivity {

    public boolean man = true;

    public double BMR = 0;
    public double TEA = 0;
//    public double TEF = 0;
    public double NEAT = 0;
    public double TDEE = BMR + TEA + NEAT;

    public int ectomorph = 800;
    public int endomorph = 300;
    public int mesomorph = 450;

    String[] active = {"Brak", "Lekka aktywność (kilka razy w miesiącu)",
            "Umiarkowana aktywność (1-2 w tygodniu)", "Duża aktywność (3-5 w tygodniu)",
            "Bardzo duża aktywność (codzienie, praca fizyczna, itp.)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, active);

        final Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy

            }
        });


        Button button = (Button) findViewById(R.id.buttonCalculate);
        OnClickListener click = new OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDailyLimit(v);
            }
        };
        button.setOnClickListener(click);

    }

    public double calculateTEA(char choice)
    {
        double tea = 0;

        switch(choice)
        {
            case 1:
                tea += 0;
                break;
            case 2:
                tea += 5;
                break;
            case 3:
                tea += 35;
                break;
            case 4:
                tea += 72;
                break;
            case 5:
                tea += 180;
                break;
            default:
                tea += 0;
                break;
        }

        return tea;
    }

    public double calculateDailyLimit(View view)
    {
//        if(!man)
//        {
//            BMR = (9.99 * weight) + (6.25 * growth) - (4.92 * age) - 161;
//            TEA = calculateTEA(choice);
//            NEAT = chooseType;
//            return TDEE;
//        }
//        else
//        {
//            BMR = (9.99 * weight) + (6.25 * growth) - (4.92 * age) + 5;
//            TEA = calculateTEA(choice);
//            NEAT = chooseType;
//            return TDEE;
//        }

        Intent intent = new Intent(this, Result.class);
        startActivity(intent);
       return TDEE;
    }

    public void returnToMainActivity(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    public void calculateDailyLimit(View view)
//    {
//        Intent intent = new Intent(this, Result.class);
//        startActivity(intent);
//    }

}
