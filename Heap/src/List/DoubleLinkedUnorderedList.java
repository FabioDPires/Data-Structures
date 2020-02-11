/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;

/**
 *
 * @author fabio
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    public DoubleLinkedUnorderedList() {

    }

    @Override
    public void addToFront(T element) {
        DoubleNode<T> node = new DoubleNode(element);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.head.setPrevious(node);
            node.setNext(this.head);
            this.head = node;
        }
        this.count++;
    }

    @Override
    public void addToRear(T element) {
        DoubleNode<T> node = new DoubleNode(element);

        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
        }

        this.count++;
    }

    @Override
    public void addAfter(T element, T target) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("The list is empty");
        }

        DoubleNode<T> node = new DoubleNode(element);
        DoubleNode<T> current = this.head;

        if (target.equals(this.tail.getElement())) {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
        } else {
            boolean found = false;
            while (!found && current != null) {
                if (target.equals(current.getElement())) {
                    found = true;
                } else {
                    current = current.getNext();
                }
            }

            if (!found) {
                throw new ElementNotFoundException("NOT FOUND");
            }

            current.getNext().setPrevious(node);
            node.setNext(current.getNext());
            current.setNext(node);
            node.setPrevious(current);
        }
        this.count++;
    }

}
