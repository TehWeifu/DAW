package com.example.calculatorincident.MathParser;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class PostfixEvaluator {
    public static BigDecimal evaluatePostFixExpression(final StringBuffer postfixExpr) {
        Stack<BigDecimal> stack = new Stack<>();

        postfixExpr.append(')');

        StringBuilder tmpNum = new StringBuilder();

        int index = 0;
        char currentChar = postfixExpr.charAt(index);
        while (currentChar != ')') {
            if (Character.isDigit(currentChar) || currentChar == '.') {
                tmpNum.append(currentChar);
            } else if (Character.isSpaceChar(currentChar)) {
                if (!(tmpNum.length() == 0)) {
                    stack.push(BigDecimal.valueOf(Double.parseDouble(tmpNum.toString())));
                    tmpNum = new StringBuilder();
                }
            } else {
                BigDecimal y = stack.pop();
                BigDecimal x = stack.pop();

                stack.push(calculate(x, y, currentChar));
            }
            index++;
            currentChar = postfixExpr.charAt(index);
        }

        return stack.pop();
    }

    private static BigDecimal calculate(BigDecimal op1, final BigDecimal op2, final char operator) {
        switch (operator) {
            case '+':
                return op1.add(op2);
            case '-':
                return op1.subtract(op2);
            case '*':
                return op1.multiply(op2);
            case '/':
                return op1.divide(op2, 5, RoundingMode.HALF_UP);
//            case '%':
//                return op1.remainder(op2, MathContext.DECIMAL32);
            case '^':
                return op1.pow(op2.intValue());
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }
}
