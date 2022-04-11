package com.example.myapplicationisworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        EditText myInput = findViewById(R.id.editTextTextPersonName);
        TextView myTxt = findViewById(R.id.textView);
        Button myBtn = findViewById(R.id.button);

        myBtn.setOnClickListener(e -> myTxt.setText(String.format("Hola, %s", myInput.getText())));
    }
}
