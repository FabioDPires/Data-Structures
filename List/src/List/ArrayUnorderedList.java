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
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList(int capacity) {
        super(capacity);
    }

    @Override
    public void addToFront(T element) {
        if (this.rear == this.list.length) {
            expandCapacity();
        }

        for (int i = rear - 1; i >= 0; i--) {
            this.list[i + 1] = this.list[i];
        }

        this.list[0] = element;
        this.rear++;
    }

    @Override
    public void addToRear(T element) {
        if (this.rear == this.list.length) {
            expandCapacity();
        }

        this.list[this.rear] = element;
        this.rear++;
    }

    @Override
    public void addAfter(T element, T target) throws EmptyCollectionException, ElementNotFoundException {
        int position = 0;
        boolean found = false;

        if (this.rear == this.list.length) {
            expandCapacity();
        }

        for (int i = 0; !found && i < this.rear; i++) {
            if (this.list[i].equals(target)) {
                position = i;
                found = true;
            }
        }

        if (!found) {
            throw new ElementNotFoundException("NOT FOUND");
        }

        if (position == this.rear - 1) {
            this.list[this.rear] = element;
        } else {
            for (int i = this.rear - 1; i >= position + 1; i--) {
                this.list[i + 1] = this.list[i];
            }
            this.list[position + 1] = element;
        }

        this.rear++;
    }

}
