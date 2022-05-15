package com.example.calculatorincident;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculatorincident.MathParser.InfixToPostfixConverter;
import com.example.calculatorincident.MathParser.PostfixEvaluator;

import java.math.BigDecimal;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.textResult);

        // Event listeners for numbers
        for (int i = 0; i <= 9; i++) {
            int id = getResources().getIdentifier("num" + i, "id", getPackageName());
            Button tmp = (Button) findViewById(id);
            tmp.setOnClickListener(view -> {
                editText.append(tmp.getText());
            });
        }

        // Event listeners for operators
        for (int i = 1; i <= 5; i++) {
            int id = getResources().getIdentifier("op" + i, "id", getPackageName());
            Button tmp = (Button) findViewById(id);
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
                editText.append(".");
            } else {
                editText.append("0.");
            }
        });

        // Event listener for clear button
        findViewById(R.id.opClear).setOnClickListener(view -> {
            editText.setText("");
        });

        // Event listener for equals (get result)
        findViewById(R.id.opResult).setOnClickListener(view -> {
            BigDecimal result = evaluateExpr(editText.getText().toString());

            if (result != null) {
                editText.setText(String.valueOf(result));
            } else {
                editText.setText("La expresion no es valida");
            }
        });
    }

    private static BigDecimal evaluateExpr(String expr) {
        String tmpExpr = expr.replaceAll("([+\\-*/^])", " $1 ");
        StringBuffer tmp = InfixToPostfixConverter.convertToPostfix(new StringBuffer(tmpExpr));
        BigDecimal result = PostfixEvaluator.evaluatePostFixExpression(tmp);

        return result;
    }
}