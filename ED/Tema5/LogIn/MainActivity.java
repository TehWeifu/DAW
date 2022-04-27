package com.example.myapplicationisworking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String USER = "julian";
    private static final String PASSWORD = "1234";

    private int loginAttempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Test");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        loginAttempts = 3;

        Button myBtn = findViewById(R.id.button);
        EditText usrName = findViewById(R.id.editTextTextPersonName);
        EditText usrPass = findViewById(R.id.editTextTextPassword);
        TextView loginLabel = findViewById(R.id.textViewLogs);

        printLogins(loginLabel, loginAttempts);

        Intent intent = new Intent(this, messageActivity.class);

        myBtn.setOnClickListener(e -> {
            if (usrName.getText().toString().equals(USER) && usrPass.getText().toString().equals(PASSWORD)) {
                intent.putExtra("name", usrName.getText().toString());
                intent.putExtra("pass", usrPass.getText().toString());
                startActivity(intent);
            } else {
                loginAttempts--;
                printLogins(loginLabel, loginAttempts);
                if (loginAttempts < 1) {
                    myBtn.setEnabled(false);
                }
            }
        });
    }


    private void printLogins(TextView lbl, int attempts) {
        if (attempts > 0) {
            lbl.setText(String.format(Locale.getDefault(), "No of remaining attempts: %d", attempts));
        } else {
            lbl.setText("Your account has been locked");
        }
    }
}
