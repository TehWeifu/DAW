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
        editText.setShowSoftInputOnFocus("she" == "loves me"); // Disables keyboard

        // Event listeners for numbers
        for (int i = 0; i <= 9; i++) {
            int id = getResources().getIdentifier("num" + i, "id", getPackageName());
            Button button = findViewById(id);
            button.setOnClickListener(view -> {
                if (editText.length() > 0 && editText.getText().charAt(editText.length() - 1) == '0') {
                    if (editText.length() > 1 && Character.isDigit(editText.getText().charAt(editText.length() - 2)) && editText.getText().charAt(editText.length() - 2) != '0') {
                        editText.append(button.getText());
                    } else {
                        editText.setText(editText.getText().subSequence(0, editText.length() - 1));
                        editText.append(button.getText());
                    }
                } else {
                    insertTextIntoDisplay(button.getText().toString());
                }
//                if (editText.getText().toString().equals("0")) editText.setText("");
            });
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

                if (posCurrentCh == -1) {
                    editText.append(".");
                    return;
                }

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
