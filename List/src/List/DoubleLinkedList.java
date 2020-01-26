/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Exceptions.ElementNotFoundException;
import Exceptions.NotPossibleToRemoveException;
import Exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class DoubleLinkedList<T> implements ListADT<T>, Iterable<T> {

    protected DoubleNode<T> head, tail;
    protected int count, modCount;

    public DoubleLinkedList() {
        this.count = 0;
        this.head = this.tail = null;
        this.modCount = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        DoubleNode<T> temp = this.head;

        this.head = this.head.getNext();
        this.head.setPrevious(null);

        temp.setNext(null);

        this.count--;

        if (this.count == 0) {
            this.tail = null;
        }
        this.modCount++;

        return temp.getElement();
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        DoubleNode<T> temp = this.tail;

        this.tail = this.tail.getPrevious();
        this.tail.setNext(null);
        temp.setPrevious(null);

        this.count--;

        if (this.count == 0) {
            this.head = null;
        }

        this.modCount++;

        return temp.getElement();
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        DoubleNode<T> current;

        if (this.count == 1) {
            current = this.head;
            this.head = null;
            this.tail = null;
        } else if (element.equals(this.head.getElement())) {
            return removeFirst();
        } else if (element.equals(this.tail.getElement())) {
            return removeLast();
        } else {
            boolean found = false;
            current = this.head;

            while (!found && current != null) {
                if (element.equals(current.getElement())) {
                    found = true;
                } else {
                    current = current.getNext();
                }
            }

            if (!found) {
                throw new ElementNotFoundException("NOT FOUND");
            }

            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            current.setNext(null);
            current.setPrevious(null);

            this.count--;
            this.modCount++;
        }

        return current.getElement();
    }

    @Override
    public T first() {
        return (T) this.head;
    }

    @Override
    public T last() {
        return (T) this.tail;
    }

    @Override
    public boolean contains(T target) {
        DoubleNode<T> current = this.head;
        boolean found = false;

        while (!found && current != null) {
            if (target.equals(current.getElement())) {
                found = true;
            } else {
                current = current.getNext();
            }
        }

        return found;
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

        DoubleNode<T> current = this.head;
        while (current != null) {
            s += current.toString() + "\n";
            current = current.getNext();
        }

        return s;
    }

    @Override
    public Iterator<T> iterator() {
        return new myItr();
    }

    private class myItr implements Iterator {

        private DoubleNode<T> current;
        private int expectedModCount;
        private boolean okToRemove;

        public myItr() {
            this.current = head;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            okToRemove = false;

            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException("There isn´t a next element");
            }

            DoubleNode<T> temp = this.current;

            this.current = this.current.getNext();
            okToRemove = true;

            return temp.getElement();
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            if (!okToRemove) {
                throw new RuntimeException("It´s not possible to remove");
            }

            try {
                DoubleLinkedList.this.remove((this.current.getElement()));
            } catch (ElementNotFoundException | EmptyCollectionException ex) {
                System.out.println(ex.getMessage());
            }
            okToRemove = false;
            expectedModCount = modCount;
        }

    }

}
