package com.example.calculatorincident;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculatorincident.MathParser.InfixToPostfixConverter;
import com.example.calculatorincident.MathParser.PostfixEvaluator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove blue bar and title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.hide();
        }

        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.textResult);
        editText.setShowSoftInputOnFocus(false); // Disables keyboard

        // Event listeners for numbers, operators and the dot
        for (int i = 0; i <= 15; i++) {
            int id = getResources().getIdentifier("btn" + i, "id", getPackageName());
            Button button = findViewById(id);
            button.setOnClickListener(view -> insertTextIntoDisplay(button.getText().toString()));
        }

        // Event listener for Backspace
        findViewById(R.id.opBack).setOnClickListener(view -> {
            if (editText.getSelectionStart() == editText.getSelectionEnd()) {
                if (editText.getSelectionEnd() != 0) {
                    int currentCursorPosition = editText.getSelectionStart();

                    editText.setText(String.format("%s%s",
                            editText.getText().subSequence(0, editText.getSelectionStart() - 1),
                            editText.getText().subSequence(editText.getSelectionStart(), editText.length())
                    ));

                    editText.setSelection(currentCursorPosition - 1);
                }
            } else {
                insertTextIntoDisplay("");
            }
        });

        // Event listener for clear button
        findViewById(R.id.opClear).setOnClickListener(view -> editText.setText(""));

        // Event listener for equals (get result)
        findViewById(R.id.opResult).setOnClickListener(view -> {
            try {
                BigDecimal result = evaluateExpr(editText.getText().toString());
                int tmpInteger = result.intValueExact();

                if (result.compareTo(BigDecimal.valueOf(tmpInteger)) == 0) {
                    editText.setText(String.valueOf(tmpInteger));
                } else {
                    editText.setText(String.valueOf(result));
                }

                editText.setSelection(editText.length());
            } catch (Exception ignored) {
            }
        });
    }

    private void insertTextIntoDisplay(final String str) {
        int startPos = editText.getSelectionStart();
        int endPos = editText.getSelectionEnd();

        if (startPos == endPos) {
            editText.getText().insert(startPos, str);
        } else {
            editText.getText().replace(startPos, endPos, str);
        }
    }

    private static BigDecimal evaluateExpr(String expr) {
        StringBuffer tmp = InfixToPostfixConverter.convertToPostfix(new StringBuffer(expr));
        return PostfixEvaluator.evaluatePostFixExpression(tmp);
    }
}
