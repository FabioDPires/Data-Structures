/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author fabio
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count = 0;
    private LinearNode<T> top;

    public LinkedStack() {
        this.top = null;
    }

    public LinkedStack(LinearNode<T> top) {
        this.top = top;
    }

    @Override
    public void push(T element) {
        LinearNode node = new LinearNode(element);
        if (size() == 0) {
            this.top = node;
        } else {
            node.setNext(this.top);
            this.top = node;

        }
        this.count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {

        if (size() == 0) {
            throw new EmptyCollectionException("The stack is empty");
        }
        LinearNode temp;
        if (size() == 1) {
            temp = this.top;
            this.top = null;

        } else {
            temp = this.top;
            this.top = this.top.getNext();
            temp.setNext(null);

        }
        this.count--;
        return (T) temp.getElement();
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (size() == 0) {
            throw new EmptyCollectionException("The stack is empty");
        }
        return (T) this.top;
    }

    @Override
    public boolean isEmpty() {
        return (this.count == 0);
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        String s = "";
        LinearNode<T> current = this.top;
        while (current != null) {
            s += current.toString();
            s += "\n";
            current = current.getNext();
        }
        return s;
    }

}
