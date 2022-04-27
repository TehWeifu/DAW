package com.example.myapplicationisworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class messageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        TextView textView = findViewById(R.id.textView);
        TextView textPass = findViewById(R.id.textViewPass);

        Bundle extras = getIntent().getExtras();
        String userName = extras.get("name").toString();
        String userPass = extras.get("pass").toString();

        textView.setText(String.format("Welcome %s!", userName));
        textPass.setText(String.format("Your password is: %s", userPass));
    }
}
