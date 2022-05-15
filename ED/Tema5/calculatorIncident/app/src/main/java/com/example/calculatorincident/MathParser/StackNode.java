package com.example.calculatorincident.MathParser;

public class StackNode<E> {
    private E element;
    private StackNode<E> nextNode;

    public StackNode(final E element, final StackNode<E> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    public E getElement() {
        return element;
    }

    public StackNode<E> getNextNode() {
        return nextNode;
    }
}
