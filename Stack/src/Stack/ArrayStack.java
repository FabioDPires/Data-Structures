/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import Exceptions.EmptyCollectionException;
import java.util.Arrays;

/**
 *
 * @author fabio
 */
public class ArrayStack<T> implements StackADT<T> {

    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 100;
    /**
     * int that represents both the number of elements and the next available
     * position in the array
     */
    private int top;
    /**
     * array of generic elements to represent the stack
     */
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        this.top = 0;
        this.stack = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty stack using the specified capacity.
     *
     * @param initialCapacity represents the specified capacity
     */
    public ArrayStack(int initialCapacity) {
        this.top = 0;
        this.stack = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding the
     * capacity of the stack array if necessary.
     *
     * @param element generic element to be pushed onto stack
     */
    public void push(T element) {
        if (size() == this.stack.length) {
            expandCapacity();
        }
        this.stack[this.top] = element;
        this.top++;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to
     * it. Throws an EmptyCollectionException if the stack is empty.
     *
     * @return T element removed from top of stack
     * @throws EmptyCollectionException if a pop is attempted on empty stack
     */
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        this.top--;
        T result = this.stack[this.top];

        this.stack[this.top] = null;
        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack. The element
     * is not removed from the stack. Throws an EmptyCollectionException if the
     * stack is empty.
     *
     * @return T element on top of stack
     * @throws EmptyCollectionException if a peek is attempted on empty stack
     */
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The stack is empty");
        }
        return this.stack[this.top - 1];
    }

    @Override
    public boolean isEmpty() {
        return (this.top == 0);
    }

    @Override
    public int size() {
        return this.top;
    }

    private void expandCapacity() {
        int newSize = (this.stack.length) * 2;
        T[] novaStack = (T[]) (new Object[newSize]);
        novaStack = Arrays.copyOf(this.stack, newSize);
        this.stack = novaStack;

    }

    @Override
    public String toString() {
        String s = "";
        for (int i = this.top - 1; i >= 0; i--) {
            s += this.stack[i].toString();
            s += "\n";
        }
        return s;
    }

}
