package com.example.feev1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button buttonPickOp, buttonCalculate, buttonClear;
TextView textViewOperation;
EditText editTextNumberDecimalA, editTextNumberDecimalB;
String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Screen");
        buttonPickOp = findViewById(R.id.buttonPickOp);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonClear = findViewById(R.id.buttonClear);
        textViewOperation = findViewById(R.id.textViewOperation);
        editTextNumberDecimalA = findViewById(R.id.editTextNumberDecimalA);
        editTextNumberDecimalB = findViewById(R.id.editTextNumberDecimalB);

        ActivityResultLauncher<Intent> goToPickOperation = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            operation = data.getStringExtra(PickOperation.OPERATION_KEY);
                            textViewOperation.setText(operation);
                        } else {
                            operation = "?";
                            textViewOperation.setText(operation);
                        }}});

        buttonPickOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PickOperation.class);
                goToPickOperation.launch(intent);
            }});

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextNumberDecimalA.getText().toString().isEmpty() || editTextNumberDecimalB.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter both A and B", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(operation == null){
                    Toast.makeText(MainActivity.this, "Select an operation", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (operation.equals("/") && Float.parseFloat(editTextNumberDecimalB.getText().toString()) == 0) {
                    Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                float A = Float.parseFloat(editTextNumberDecimalA.getText().toString());
                float B = Float.parseFloat(editTextNumberDecimalB.getText().toString());
                Operation calculation = new Operation(A, B,operation);
                Intent intent = new Intent(MainActivity.this, Result.class);
                intent.putExtra(Result.RESULT_KEY, calculation);
                startActivity(intent);
            }});

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumberDecimalA.setText("");
                editTextNumberDecimalB.setText("");
                textViewOperation.setText("?");
            }});}}