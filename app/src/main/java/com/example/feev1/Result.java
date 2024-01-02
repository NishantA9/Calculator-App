package com.example.feev1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {
    public static final String RESULT_KEY = "calculation";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textResult = findViewById(R.id.textViewResult);
        Button buttonClose = findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }});

        if(getIntent() != null && getIntent().hasExtra(RESULT_KEY)){
            Operation calculation = (Operation) getIntent().getSerializableExtra(RESULT_KEY);
            String resultText = String.format("Result: %.2f %s %.2f = %.2f",
                    calculation.getA(), calculation.getOperation(), calculation.getB(),
                    performCalculation(calculation));
            textResult.setText(resultText);
        } else {
            textResult.setText("No calculation data found");
        }
    }
        private float performCalculation(Operation calculation){
        switch (calculation.getOperation()){
            case "+":
                return  calculation.getA() + calculation.getB();
            case "-":
                return  calculation.getA() - calculation.getB();
            case "*":
                return  calculation.getA() * calculation.getB();
            case "/":
                if(calculation.getB() == 0){
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                }else{
                return  calculation.getA() / calculation.getB();}
            default:
                return 0;
        }}}
