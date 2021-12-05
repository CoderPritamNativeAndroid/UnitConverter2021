package com.pritampachal.unitconverter2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton=findViewById(R.id.toggleButtonTouchMe);
        editText=findViewById(R.id.editTextTextPersonNameEnterValue);
        button=findViewById(R.id.buttonResult);
        textView=findViewById(R.id.textViewResult);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked()) {
                    editText.setHint("Enter Value (POUND)");
                } else {
                    editText.setHint("Enter Value (KG)");
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(editText.getText().toString().trim().equals("")) {
                        Toast.makeText(MainActivity.this, "Enter Some Value\nThis Field Required", Toast.LENGTH_SHORT).show();
                    } else {
                        if(toggleButton.isChecked()) {
                            Double input1=Double.parseDouble(editText.getText().toString().trim());
                            Double result1=input1/2.20462;
                            Toast.makeText(MainActivity.this, input1+" POUND=="+result1+" KG", Toast.LENGTH_SHORT).show();
                            textView.setText(input1+" POUND=="+result1+" KG");
                        } else {
                            Double input1=Double.parseDouble(editText.getText().toString().trim());
                            Double result1=input1*2.20462;
                            Toast.makeText(MainActivity.this, input1+" KG=="+result1+" POUND", Toast.LENGTH_SHORT).show();
                            textView.setText(input1+" KG=="+result1+" POUND");
                        }
                    }
                } catch(Exception e) {
                    Toast.makeText(MainActivity.this, "Enter Only Number Value", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
