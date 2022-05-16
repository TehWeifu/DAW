package com.example.calculatorincident;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculatorincident.MathParser.InfixToPostfixConverter;
import com.example.calculatorincident.MathParser.PostfixEvaluator;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.textResult);

        // Event listeners for numbers
        for (int i = 0; i <= 9; i++) {
            int id = getResources().getIdentifier("num" + i, "id", getPackageName());
            Button tmp = findViewById(id);
            tmp.setOnClickListener(view -> editText.append(tmp.getText()));
        }

        // Event listeners for operators
        for (int i = 1; i <= 5; i++) {
            int id = getResources().getIdentifier("op" + i, "id", getPackageName());
            Button tmp = findViewById(id);
            tmp.setOnClickListener(view -> {
                if (editText.length() > 0 && Character.isDigit(editText.getText().charAt(editText.length() - 1))) {
                    editText.append(tmp.getText());
                    return;
                }
                if (editText.length() > 0 && editText.getText().charAt(editText.length() - 1) == '.') {
                    editText.setText(editText.getText().subSequence(0, editText.length() - 1));
                    editText.append(tmp.getText());
                }
            });
        }

        // Event listener for Backspace
        findViewById(R.id.opBack).setOnClickListener(view -> {
            if (!editText.getText().toString().isEmpty())
                editText.setText(editText.getText().subSequence(0, editText.length() - 1));
        });

        // Event listener for Point
        findViewById(R.id.opPoint).setOnClickListener(view -> {
            if (editText.length() == 0) {
                editText.setText("0.");
                return;
            }

            char lastCh = editText.getText().charAt(editText.length() - 1);
            if (lastCh == '.') return;
            if (Character.isDigit(lastCh)) {
                int posCurrentCh = editText.length() - 1;
                while (posCurrentCh >= 0 && Character.isDigit(editText.getText().toString().charAt(posCurrentCh))) {
                    posCurrentCh--;
                }

                if (posCurrentCh == -1) return;
                if (editText.getText().charAt(posCurrentCh) == '.') return;

                editText.append(".");
            } else {
                editText.append("0.");
            }
        });

        // Event listener for clear button
        findViewById(R.id.opClear).setOnClickListener(view -> editText.setText(""));

        // Event listener for equals (get result)
        findViewById(R.id.opResult).setOnClickListener(view -> {
            try {
                BigDecimal result = evaluateExpr(editText.getText().toString());
                editText.setText(String.valueOf(result));
            } catch (Exception e) {
            }
        });
    }

    private static BigDecimal evaluateExpr(String expr) {
        StringBuffer tmp = InfixToPostfixConverter.convertToPostfix(new StringBuffer(expr));
        return PostfixEvaluator.evaluatePostFixExpression(tmp);
    }
}