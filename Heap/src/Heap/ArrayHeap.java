/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author fabio
 */
/**
 * ArrayHeap provides an array implementation of a minheap.
 *
 * @param <T>
 */
public class ArrayHeap<T> extends ArrayBinaryTree<T>
        implements HeapADT<T> {

    public ArrayHeap() {
        super();
    }

    @Override
    public void addElement(T obj) {
        if (this.count == this.tree.length) {
            expandCapacity();
        }
        this.tree[this.count] = obj;
        this.count++;
        if (this.count > 1) {
            heapifyAdd();
        }

    }

    @Override
    public T removeMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Heap");
        }
        T minElement = this.tree[0];
        this.tree[0] = this.tree[this.count - 1];
        heapifyRemove();

        this.count--;
        this.tree[this.count] = null;
        return minElement;
    }

    @Override
    public T findMin() {
        return this.tree[0];
    }

    private void heapifyAdd() {
        T temp;
        int next = this.count - 1;

        temp = this.tree[next];

        while ((next != 0) && (((Comparable) temp).compareTo(this.tree[(next - 1) / 2]) < 0)) {
            this.tree[next] = this.tree[(next - 1) / 2];
            next = (next - 1) / 2;
        }
        this.tree[next] = temp;
    }

    private void expandCapacity() {
        int newSize = this.tree.length * 2 + 1;
        T[] newTree = (T[]) new Object[newSize];

        for (int i = 0; i < this.tree.length; i++) {
            newTree[i] = this.tree[i];
        }

        this.tree = newTree;
    }

    private void heapifyRemove() {
        T temp;
        int node = 0;
        int left = 1;
        int right = 2;
        int next;

        if ((this.tree[left] == null) && (this.tree[right] == null)) {
            next = this.count;
        } else if (this.tree[left] == null) {
            next = right;
        } else if (this.tree[right] == null) {
            next = left;
        } else if (((Comparable) this.tree[left]).compareTo(this.tree[right]) < 0) {
            next = left;
        } else {
            next = right;
        }
        temp = this.tree[node];
        while ((next < this.count) && (((Comparable) this.tree[next]).compareTo(temp) < 0)) {
            this.tree[node] = this.tree[next];
            node = next;
            left = 2 * node + 1;
            right = 2 * (node + 1);
            if ((this.tree[left] == null) && (this.tree[right] == null)) {
                next = this.count;
            } else if (this.tree[left] == null) {
                next = right;
            } else if (this.tree[right] == null) {
                next = left;
            } else if (((Comparable) this.tree[left]).compareTo(this.tree[right]) < 0) {
                next = left;
            } else {
                next = right;
            }
        }
        this.tree[node] = temp;

    }
}
