/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Exceptions.ElementNotFoundException;

import Exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *
 * @author fabio
 */
public class ArrayList<T> implements ListADT<T>, Iterable<T> {

    private static final int EXPAND_BY = 2;
    private static final int NOT_FOUND = 2;
    private static final int DEFAULT_CAPACITY = 20;

    private int modCount;

    protected T[] list;
    protected int rear;

    public ArrayList() {
        this.rear = 0;
        list = (T[]) new Object[DEFAULT_CAPACITY];
        this.modCount = 0;
    }

    public ArrayList(int capacity) {
        this.rear = 0;
        list = (T[]) new Object[capacity];
        this.modCount = 0;
    }

    public T[] getList() {
        return this.list;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        T removed = this.list[0];
        for (int i = 0; i < this.rear - 1; i++) {
            this.list[i] = this.list[i + 1];
        }

        this.rear--;
        this.list[this.rear] = null;
        this.modCount++;

        return removed;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        this.rear--;
        T removed = this.list[this.rear];
        this.list[this.rear] = null;
        this.modCount++;

        return removed;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        int position = -1;
        int i = 0;
        boolean found = false;
        while (!found && i < this.rear) {
            if (element.equals(this.list[i])) {
                position = i;
                found = true;
            }
            i++;
        }

        if (!found) {
            throw new ElementNotFoundException("NOT FOUND");
        }

        T removed = list[position];
        for (int j = position; j < this.rear - 1; j++) {
            this.list[j] = this.list[j + 1];
        }

        this.rear--;
        this.list[this.rear] = null;
        this.modCount++;

        return removed;
    }

    @Override
    public T first() {
        return this.list[0];
    }

    @Override
    public T last() {
        return this.list[this.rear - 1];
    }

    @Override
    public boolean contains(T target) {
        int i = 0;
        boolean found = false;

        while (!found && i < this.rear) {
            if (target.equals(this.list[i])) {
                found = true;
            }
            i++;
        }

        return found;
    }

    @Override
    public boolean isEmpty() {
        return this.rear == 0;
    }

    @Override
    public int size() {
        return this.rear;
    }

    @Override
    public Iterator iterator() {
        return new myItr();
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < this.rear; i++) {
            s += this.list[i] + "\n";
        }

        return s;
    }

    protected void expandCapacity() {
        int newSize = (this.list.length) * EXPAND_BY;
        T[] newList = (T[]) (new Object[newSize]);

        //System.out.println("Tamanho amumentado");
        //System.out.println("Novo tamanho=" + novoVetor.length);
        for (int i = 0; i < this.list.length; i++) {
            newList[i] = this.list[i];
        }

        this.list = newList;
    }

    private class myItr<T> implements Iterator<T> {

        private int current;
        private int expectedModCount;

        public myItr() {
            this.current = 0;
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            return current != size();
        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new ArrayIndexOutOfBoundsException("There isn´t a next elenent");

            }

            return (T) list[this.current++];
        }

    }

}
