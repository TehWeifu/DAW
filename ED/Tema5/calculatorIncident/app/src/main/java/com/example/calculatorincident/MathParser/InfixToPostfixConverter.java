package com.example.calculatorincident.MathParser;

import java.util.Scanner;

public class InfixToPostfixConverter {
    public static StringBuffer convertToPostfix(StringBuffer infix) {
        StringBuffer postfix = new StringBuffer();

        StringBuilder tmpNum = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        infix = new StringBuffer(infix.toString().replaceAll("([+\\-*/^])", " $1 "));

        stack.push('(');
        infix.append(')');

        for (int i = 0; i < infix.length() && !stack.isEmpty(); i++) {
            char currentChar = infix.charAt(i);

            if (Character.isDigit(currentChar) || currentChar == '.') {
                tmpNum.append(currentChar);
            }

            if (Character.isSpaceChar(currentChar)) {
                if (tmpNum.length() > 0) {
                    postfix.append(tmpNum).append(' ');
                    tmpNum = new StringBuilder();
                }
            }

            if (currentChar == '(') {
                stack.push(currentChar);
            }

            if (isOperator(currentChar)) {
                char topStack = stack.peek();
                while (isOperator(topStack) && !precedence(topStack, currentChar)) {
                    postfix.append(stack.pop()).append(' ');
                    topStack = stack.peek();
                }
                stack.push(currentChar);
            }

            if (currentChar == ')') {
                if (tmpNum.length() > 0) {
                    postfix.append(tmpNum).append(' ');
                    tmpNum = new StringBuilder();
                }

                char topStack = stack.peek();

                while (topStack != '(') {
                    if (isOperator(topStack)) {
                        postfix.append(topStack).append(' ');
                    }
                    stack.pop();
                    topStack = stack.peek();
                }
                stack.pop();
            }
        }
        return postfix;
    }

    private static boolean isOperator(char ch) {
        if (ch == '+') return true;
        if (ch == '-') return true;
        if (ch == '*') return true;
        if (ch == '/') return true;
        if (ch == '^') return true;
        return ch == '%';
    }

    // Return true if op1 has lower precedence than op2
    private static boolean precedence(char op1, char op2) {
        if (op1 == op2) return false;
        if (op1 == '^') return false;
        if (op1 == '*' || op1 == '/' || op1 == '%') {
            return op2 == '^';
        }
        return op2 != '+' && op2 != '-';
    }
}
