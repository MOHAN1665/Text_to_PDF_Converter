package com.example.texttopdfconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInputEditText = findViewById(R.id.userInputEditText);
        Button convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(v -> {
            String userInput = userInputEditText.getText().toString().trim();
            if (!userInput.isEmpty()) {
                convertTextToPdf(userInput);
            } else {
                Toast.makeText(MainActivity.this, "Please enter text to convert.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void convertTextToPdf(String textContent) {
        PdfConverter.textToPdf(MainActivity.this, textContent);
    }
}
