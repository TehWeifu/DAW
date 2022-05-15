package com.example.calculatorincident.MathParser;

import java.util.NoSuchElementException;

public class Stack<E> {
    private final List<E> stackList;

    // constructor
    public Stack() {
        stackList = new List<>("stack");
    }

    // add object to stack
    public void push(E object) {
        stackList.insertAtFront(object);
    }

    // remove object from stack
    public E pop() throws NoSuchElementException {
        return stackList.removeFromFront();
    }

    public E peek() {
        E element = pop();
        push(element);
        return element;
    }

    // determine if stack is empty
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    // output stack contents
    public void print() {
        stackList.print();
    }

}