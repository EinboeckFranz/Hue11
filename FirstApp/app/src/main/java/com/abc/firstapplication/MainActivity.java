package com.abc.firstapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reduceBtn = findViewById(R.id.reduceBtn);
        reduceBtn.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        TextView nominator = findViewById(R.id.zaehler),
                denominator = findViewById(R.id.nenner);

        int nominatorAsInt = Integer.parseInt(nominator.getText().toString()),
                denominatorAsInt = Integer.parseInt(denominator.getText().toString());


        int divider = denominatorAsInt,
                rest = nominatorAsInt % denominatorAsInt,
                separator = 0;

        while (rest != 0) {
            separator = rest;

            int tempNr = rest;
            rest = rest % divider;
            divider = tempNr;

            if(rest!=0)
                break;
        }

        nominator.setText(Integer.toString(nominatorAsInt/separator));
        denominator.setText(Integer.toString(denominatorAsInt/separator));
    }
}