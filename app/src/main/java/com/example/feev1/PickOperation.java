package com.example.feev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class PickOperation extends AppCompatActivity {
    public static final String OPERATION_KEY = "key";
    RadioGroup radioGroup;
    Button buttonSelect, buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_operation);
        radioGroup = findViewById(R.id.radioGroup);
        buttonSelect = findViewById(R.id.buttonSelect);
        buttonCancel = findViewById(R.id.buttonCancel);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operation = "?";
                if(radioGroup.getCheckedRadioButtonId() == R.id.radioButtonSub){
                    operation = "-";
                    Intent intent = new Intent();
                    intent.putExtra(OPERATION_KEY, operation);
                    setResult(RESULT_OK, intent);
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonMultiply) {
                    operation = "*";
                    Intent intent = new Intent();
                    intent.putExtra(OPERATION_KEY, operation);
                    setResult(RESULT_OK, intent);
                }else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonAdd) {
                    operation = "+";
                    Intent intent = new Intent();
                    intent.putExtra(OPERATION_KEY, operation);
                    setResult(RESULT_OK, intent);
                }else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonDivide) {
                    operation = "/";
                    Intent intent = new Intent();
                    intent.putExtra(OPERATION_KEY, operation);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }});}}