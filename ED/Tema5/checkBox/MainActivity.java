package com.example.myapplicationisworking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        LinearLayout chkLay = findViewById(R.id.checkGroup);
        for (int i = 0; i < chkLay.getChildCount(); i++) {
            chkLay.getChildAt(i).setOnClickListener(l -> {

                TextView txt = findViewById(R.id.textView);
                CheckBox ch1 = findViewById(R.id.checkBox);
                CheckBox ch2 = findViewById(R.id.checkBox2);
                CheckBox ch3 = findViewById(R.id.checkBox3);

                txt.setText("You select:");

                if (ch1.isChecked()) txt.append(String.format("%n%s", ch1.getText().toString()));
                if (ch2.isChecked()) txt.append(String.format("%n%s", ch2.getText().toString()));
                if (ch3.isChecked()) txt.append(String.format("%n%s", ch3.getText().toString()));
            });
        }
    }
}
