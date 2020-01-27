/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Exceptions.NotComparableException;

/**
 *
 * @author fabio
 */
public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    public OrderedDoubleLinkedList() {
    }

    @Override
    public void add(T element) throws NotComparableException {
        if (!(element instanceof Comparable)) {
            throw new NotComparableException();
        }

        Comparable<T> comp = (Comparable<T>) element;
        DoubleNode<T> node = new DoubleNode(element);
        DoubleNode<T> current = this.head;

        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else if (comp.compareTo(current.getElement()) < 0) {
            current.setPrevious(node);
            node.setNext(current);
            this.head = node;
        } else if (comp.compareTo(this.tail.getElement()) >= 0) {
            current = this.tail;
            current.setNext(node);
            node.setPrevious(current);
            this.tail = node;
        } else {

            while (current != null && comp.compareTo(current.getElement()) >= 0) {

                current = current.getNext();

            }

            current.getPrevious().setNext(node);
            node.setPrevious(current.getPrevious());
            current.setPrevious(node);
            node.setNext(current);
        }

        this.count++;
        this.modCount++;
    }

}
