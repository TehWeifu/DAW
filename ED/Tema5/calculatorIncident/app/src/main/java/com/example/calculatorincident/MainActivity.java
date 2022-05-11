package com.example.calculatorincident;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.textResult);

        for (int i = 0; i <= 9; i++) {
            int id = getResources().getIdentifier("num" + i, "id", getPackageName());
            Button tmp = (Button) findViewById(id);
            tmp.setOnClickListener(view -> {
                editText.append(tmp.getText());
            });
        }
        for (int i = 1; i <= 4; i++) {
            int id = getResources().getIdentifier("op" + i, "id", getPackageName());
            Button tmp = (Button) findViewById(id);
            tmp.setOnClickListener(view -> {
                editText.append(tmp.getText());
            });
        }

        findViewById(R.id.opBack).setOnClickListener(view -> {
            if (!editText.getText().toString().isEmpty())
                editText.setText(editText.getText().subSequence(0, editText.length() - 1));
        });

        findViewById(R.id.opResult).setOnClickListener(view -> {
            Double result = evaluateExpr(editText.getText().toString());

            if (result != null) {
                editText.setText(String.valueOf(result));
            } else {
                editText.setText("La expresion no es valida");
            }
        });
    }

    private static Double evaluateExpr(String expr) {
        double result = 0.0;

        StringBuilder tmpVal = new StringBuilder();
        Character lastOp = null;
        for (int i = 0; i < expr.length(); i++) {
            if (Character.isDigit(expr.charAt(i)) || '.' == expr.charAt(i)) {
                tmpVal.append(expr.charAt(i));
            } else {
                if (lastOp == null) {
                    lastOp = expr.charAt(i);
                    result = Double.parseDouble(tmpVal.toString());
                    tmpVal = new StringBuilder();
                } else {
                    switch (lastOp) {
                        case '+':
                            result += Double.parseDouble(tmpVal.toString());
                            break;
                        case '-':
                            result -= Double.parseDouble(tmpVal.toString());
                            break;
                        case '*':
                            result *= Double.parseDouble(tmpVal.toString());
                            break;
                        case '/':
                            result /= Double.parseDouble(tmpVal.toString());
                            break;
                    }
                    lastOp = expr.charAt(i);
                    tmpVal = new StringBuilder();
                }
            }
        }
        switch (lastOp) {
            case '+':
                result += Double.parseDouble(tmpVal.toString());
                break;
            case '-':
                result -= Double.parseDouble(tmpVal.toString());
                break;
            case '*':
                result *= Double.parseDouble(tmpVal.toString());
                break;
            case '/':
                result /= Double.parseDouble(tmpVal.toString());
                break;
        }
        return result;
    }
}