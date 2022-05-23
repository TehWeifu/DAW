package com.example.calculatorincident;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculatorincident.MathParser.InfixToPostfixConverter;
import com.example.calculatorincident.MathParser.PostfixEvaluator;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Toast toast;

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

        // Pop up message when evaluating a bad expression
        Context context = getApplicationContext();
        CharSequence text = "Not a valid expression";
        int duration = Toast.LENGTH_SHORT;
        toast = Toast.makeText(context, text, duration);


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
                    int positionsFromEnd = editText.length() - editText.getSelectionEnd();

                    editText.setText(String.format("%s%s",
                            editText.getText().subSequence(0, editText.getSelectionStart() - 1),
                            editText.getText().subSequence(editText.getSelectionStart(), editText.length())
                    ));

                    insertTextIntoDisplay("");
                    editText.setSelection(editText.length() - positionsFromEnd);
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
                int tmpInteger = result.intValue();

                if (result.compareTo(BigDecimal.valueOf(tmpInteger)) == 0) {
                    editText.setText(String.valueOf(tmpInteger));
                } else {
                    editText.setText(String.valueOf(result));
                }
            } catch (Exception ignored) {
                showToast("Not a valid expression");
            } finally {
                editText.setText(expressionCleanUp(editText.getText().toString()));
                fancyText();
                editText.setSelection(editText.length());
            }
        });
    }

    private void insertTextIntoDisplay(final String str) {
        int startPos = editText.getSelectionStart();
        int endPos = editText.getSelectionEnd();
        int positionsFromEnd = editText.length() - endPos;

        if (startPos == endPos) {
            editText.getText().insert(startPos, str);
        } else {
            editText.getText().replace(startPos, endPos, str);
        }

        editText.setText(expressionCleanUp(editText.getText().toString()));
        fancyText();

        editText.setSelection(editText.length() - positionsFromEnd);
    }

    private static BigDecimal evaluateExpr(String expr) {
        StringBuffer tmp = InfixToPostfixConverter.convertToPostfix(new StringBuffer(expr));
        return PostfixEvaluator.evaluatePostFixExpression(tmp);
    }

    private String expressionCleanUp(String expression) {
        // REGEX TRAP HOUSE
        expression = expression.replaceAll("^0(\\d.*)", "$1");
        expression = expression.replaceAll("(.*[+\\-*/^])0(\\d.*)", "$1$2");

        expression = expression.replaceAll("^\\.", "0.");
        expression = expression.replaceAll("\\.\\.", ".");
        expression = expression.replaceAll("(.*)\\.([+\\-*/^])", "$1$2");
        expression = expression.replaceAll("(\\.\\d+)\\.", "$1");
        expression = expression.replaceAll("([+\\-*/^])(\\.)", "$10$2");

        expression = expression.replaceAll("([+\\-*/^])([+\\-*/^])", "$1");

        expression = expression.replaceAll("(\\.[1-9])0+$", "$1"); // trailing 0
        expression = expression.replaceAll("(\\.[1-9])0+(\\D)", "$1$2"); // trailing 0
        expression = expression.replaceAll("\\.0+(\\D)", "$1"); // trailing 0

        return expression;
    }

    private void fancyText() {
        Editable result = editText.getText();

        for (int i = 0; i < result.length(); i++) {
            if ((result.charAt(i) + "").matches("[+\\-*/^]")) {
                result.setSpan(new ForegroundColorSpan(Color.parseColor("#008f39")), i, i + 1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            }
        }
        editText.setText(result);
    }

    private void showToast(final String message) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
