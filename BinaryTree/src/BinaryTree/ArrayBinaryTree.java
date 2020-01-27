/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;



import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import List.ArrayUnorderedList;
import Queue.LinkedQueue;
import Queue.QueueADT;
import java.util.Iterator;


/**
 *
 * @author fabio
 * @param <T>
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected T[] tree;
    private final int CAPACITY = 50;

    /**
     * Creates an empty binary tree.
     */
    public ArrayBinaryTree() {
        this.count = 0;
        this.tree = (T[]) new Object[CAPACITY];
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element which will become the root of the new tree
     */
    public ArrayBinaryTree(T element) {
        this.count = 1;
        this.tree = (T[]) new Object[CAPACITY];
        this.tree[0] = element;
    }

    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree. Throws a NoSuchElementException if the specified target
     * element is not found in the binary tree.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the element is in the tree
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        T temp = null;
        boolean found = false;

        for (int ct = 0; !found && ct < this.count; ct++) {
            if (targetElement.equals(this.tree[ct])) {
                found = true;
                temp = this.tree[ct];
            }
        }
        if (!found) {
            throw new ElementNotFoundException("That element doesn´t exist!");
        }
        return temp;
    }

    @Override
    public T getRoot() throws EmptyCollectionException {
        if (this.count == 0) {
            throw new EmptyCollectionException("The tree is empty");
        }

        return tree[0];
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
    public boolean contains(T targetElement) {
        try {
            find(targetElement);
            return true;
        } catch (ElementNotFoundException ex) {
            return false;
        }

    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>(this.count);
        inorder(0, templist);
        return templist.iterator();
    }

    protected void inorder(int node, ArrayUnorderedList<T> templist) {
        if (node < this.tree.length) {
            if (this.tree[node] != null) {
                inorder(node * 2 + 1, templist);
                templist.addToRear(this.tree[node]);
                inorder((node + 1) * 2, templist);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>(this.count);
        preorder(0, templist);
        return templist.iterator();
    }

    protected void preorder(int node, ArrayUnorderedList<T> templist) {
        if (node < this.tree.length) {
            if (this.tree[node] != null) {
                templist.addToRear(this.tree[node]);
                inorder(node * 2 + 1, templist);
                inorder((node + 1) * 2, templist);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>(this.count);
        postorder(0, templist);
        return templist.iterator();
    }

    protected void postorder(int node, ArrayUnorderedList<T> templist) {
        if (node < this.tree.length) {
            if (this.tree[node] != null) {
                inorder(node * 2 + 1, templist);
                inorder((node + 1) * 2, templist);
                templist.addToRear(this.tree[node]);
            }
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder(){
        QueueADT<Integer> values = new LinkedQueue<>();
        ArrayUnorderedList<Integer> results = new ArrayUnorderedList<>(this.count);
        int position = 0;

        values.enqueue(position);

        while (!(values.isEmpty())) {

            try {
                position = values.dequeue();

                if (this.tree[position] != null) {
                    results.addToRear(position);

                    if (this.tree[(position * 2) + 1] != null) {
                        values.enqueue((position * 2) + 1);
                    }

                    if (this.tree[2 * (position + 1)] != null) {
                        values.enqueue(2 * (position + 1));
                    }
                }
            } catch (EmptyCollectionException ex) {
                System.out.println("Empty");;
            }

        }
        return results.iterator();
    }



}
