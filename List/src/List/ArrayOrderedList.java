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
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    public ArrayOrderedList(int capacity) {
        super(capacity);
    }

    @Override
    public void add(T element) throws NotComparableException {
        if (!(element instanceof Comparable)) {
            throw new NotComparableException();
        }

        if (this.rear == this.list.length) {
            this.expandCapacity();
        }

        Comparable<T> comp = (Comparable<T>) element;
        int i = 0;
        boolean bigger = true;
        int posicao = 0;

        while (!bigger && i < rear) {
            if (comp.compareTo(list[i]) > 0) {
                posicao++;
            } else {
                bigger = false;
            }
            i++;
        }

        for (int j = rear; j > posicao; j--) {
            list[j] = list[j - 1];
        }

        list[posicao] = element;

        rear++;
    }

}
