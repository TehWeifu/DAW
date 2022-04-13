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
        Bundle extras = getIntent().getExtras();
        String userSuperHero = extras.get("name").toString();

        textView.setText(String.format("Tu superheroe favorito es %s.", userSuperHero));
        if (userSuperHero.matches("[Tt]inky[- ]?[Ww]inky")) {
            ConstraintLayout myLayout = findViewById(R.id.mainLayout);
            myLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.tinkywinky));
            textView.append(" SAME");
        } else {
            textView.append(" Los hay mejores tho");
        }
    }
}
