/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author fabio
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private LinearNode<T> rear;
    private LinearNode<T> front;
    private int count = 0;

    public LinkedQueue() {
        this.rear = null;
        this.front = null;
    }

    @Override
    public void enqueue(T element) {
        LinearNode node = new LinearNode(element);
        if (this.count == 0) {
            this.rear = node;
            this.front = node;

        } else {
            this.rear.setNext(node);
            this.rear = node;

        }
        this.count++;

    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The queue is empty");
        }
        LinearNode temp;
        if (this.count == 1) {
            temp = this.front;
            this.rear = null;
            this.front = null;
        } else {
            temp = this.front;
            this.front = this.front.getNext();
            temp.setNext(null);

        }
        this.count--;
        return (T) temp.getElement();
    }

    @Override
    public T first() {
        return (T) this.front;
    }

    @Override
    public boolean isEmpty() {
        return this.count==0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        String s = "";
        LinearNode<T> current = this.front;
        while (current != null) {
            s += current.toString();
            s += "\n";
            current = current.getNext();
        }
        return s;
    }

}
