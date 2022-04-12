package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Test");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        Button myBtn = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editTextTextPersonName);

        Intent intent = new Intent(this, messageActivity.class);

        myBtn.setOnClickListener(e -> {
            intent.putExtra("name", editText.getText().toString());
            startActivity(intent);
        });
    }
}
