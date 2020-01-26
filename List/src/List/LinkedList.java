/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 *
 * @author fabio
 * @param <T>
 */
public class LinkedList<T> {

    private LinearNode<T> head, tail;
    private int count;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void add(T element) {
        LinearNode<T> node = new LinearNode<>(element);

        if (this.count == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }

        this.count++;

    }

    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        LinearNode<T> temp = this.head;

        this.head = head.getNext();
        temp.setNext(null);

        this.count--;

        if (this.count == 0) {
            this.tail = null;
        }

        return temp.getElement();
    }

    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        LinearNode<T> previous = null;
        LinearNode<T> current = this.head;
        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }
        LinearNode<T> result = this.tail;
        this.tail = previous;
        this.tail.setNext(null);
        this.count--;

        if (this.count == 0) {
            this.head = null;
        }

        return result.getElement();
    }

    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        boolean found = false;

        LinearNode<T> previous = null;
        LinearNode<T> current = this.head;

        while (!found && current != null) {
            if (element.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            throw new ElementNotFoundException("NOT FOUND");
        }

        if (this.count == 1) {
            this.head = null;
            this.tail = null;
        } else if (current.equals(this.head)) {
            this.head = current.getNext();
        } else if (current.equals(this.tail)) {
            this.tail = previous;
            this.tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }

        this.count--;

        return current.getElement();
    }

    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        return this.head.getElement();
    }

    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        return this.tail.getElement();
    }

    public boolean contains(T target) throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        boolean found = false;
        LinearNode<T> current = this.head;

        while (!found && current != null) {
            if (target.equals(current.getElement())) {
                found = true;
            } else {
                current = current.getNext();
            }
        }

        return found;

    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        LinearNode<T> current=this.head;
        while(current!=null){
            System.out.println(current.getElement());
            current=current.getNext();
        }
        return "This is a linked list with "+this.count+" elements";
    }
    
    

}
