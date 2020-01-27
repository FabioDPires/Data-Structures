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
public class CircularArrayQueue<T> implements QueueADT<T> {

    private final int DEFAULT_CAPACITY = 100;
    private int front;
    private int rear;
    private T[] circularArray;
    private int count = 0;

    public CircularArrayQueue() {
        this.front = 0;
        this.rear = 0;
        this.circularArray = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public CircularArrayQueue(int tamanho) {
        this.front = 0;
        this.rear = 0;
        this.circularArray = (T[]) new Object[tamanho];
    }

    @Override
    public void enqueue(T element) {
        if (this.count == this.circularArray.length) {
            expandCapacity();

        }
        this.circularArray[this.rear] = element;
        this.rear = (this.rear + 1) % this.circularArray.length;
        this.count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (this.count == 0) {
            throw new EmptyCollectionException("The queue is empty");
        }

        T temp = this.circularArray[this.front];
        this.circularArray[this.front] = null;
        this.front = (this.front + 1) % this.circularArray.length;
        this.count--;
        return temp;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The queue is empty");
        }

        return this.circularArray[this.front];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        String s = "";
        int j = this.front;
        for (int i = 0; i < this.count; i++) {
            s += this.circularArray[j].toString();
            s += " \n";
            j = (j + 1) % this.circularArray.length;
        }
        return s;
    }

    private void expandCapacity() {
        int newSize = (this.circularArray.length) * 2;
        T[] newQueue = (T[]) (new Object[newSize]);
        int j = this.front;
        for (int i = 0; i < this.count; i++) {
            newQueue[i] = this.circularArray[j];
            j = (j + 1) % this.circularArray.length;
        }
        this.front = 0;
        this.rear = this.count;
        this.circularArray = newQueue;
    }

}
