/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

import Exceptions.ElementNotFoundException;

/**
 *
 * @author fabio
 */
/**
 * ArrayBinarySearchTree implements a binary search tree using an array.
 *
 *
 */
/**
 * ArrayBinarySearchTree implements a binary search tree using an array.
 *
 * @param <T>
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {

    protected int height;
    protected int maxIndex;

    /**
     * Creates an empty binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Creates a binary search with the specified element as its root
     *
     * @param element the element that will become the root of the new tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 1;
        maxIndex = 0;

    }

    @Override
    public void addElement(T element) {
        if (tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }
        Comparable<T> tempelement = (Comparable<T>) element;
        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;
            while (!added) {
                if (tempelement.compareTo((tree[currentIndex])) < 0) {
                    /**
                     * go left
                     */
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    /**
                     * go right
                     */
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }
        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeMin() {
        int position = 0;
        T result = null;

        if (this.tree[position * 2 + 1] == null) {
            result = this.tree[position];
            this.tree[position] = replacement(position);
            this.count--;
        } else {
            while (this.tree[2 * position + 1] != null) {
                position = 2 * position + 1;
            }

            this.tree[position] = replacement(position);

        }

        return result;
    }

    @Override
    public T removeMax() {
        int position=0;
        T result=null;
        
        if(this.tree[2*(position+1)]==null){
            result=this.tree[position];
            this.tree[position]=replacement(position);
            
        }
        
        return result;
    }

    @Override
    public T findMin() {
        int position = 0;
        while (this.tree[position * 2 + 1] != null) {
            position = position * 2 + 1;
        }
        return this.tree[position];
    }

    @Override
    public T findMax() {
        int position = 0;
        while (this.tree[2 * (position + 1)] != null) {
            position = 2 * (position + 1);
        }
        return this.tree[position];
    }

    private void expandCapacity() {
        int newSize = this.tree.length * 2 + 1;
        T[] newTree = (T[]) new Object[newSize];

        for (int i = 0; i < this.tree.length; i++) {
            newTree[i] = this.tree[i];
        }
        System.out.println("Tamanho aumentado");
        this.tree = newTree;
    }

    private T replacement(int position) {
        T result = null;

        if (this.tree[2 * position + 1] == null && this.tree[2 * (position + 1)] == null) {
            result = null;
        } else if (this.tree[2 * position + 1] == null && this.tree[2 * (position + 1)] != null) {
            result = this.tree[2 * (position + 1)];
            this.tree[2 * (position + 1)] = null;
        } else if (this.tree[2 * position + 1] != null && this.tree[2 * (position + 1)] == null) {
            result = this.tree[2 * position + 1];
            this.tree[2 * position + 1] = null;
        }

        return result;
    }
}
