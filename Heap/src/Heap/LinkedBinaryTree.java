/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import List.ArrayUnorderedList;
import Queue.LinkedQueue;
import Queue.QueueADT;

import java.util.Iterator;

/**
 *
 * @author fabio
 */
/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 *
 * @param <T>
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected BinaryTreeNode<T> root;

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() {
        this.count = 0;
        this.root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the new binary
     * tree
     */
    public LinkedBinaryTree(T element) {
        this.count = 1;
        this.root = new BinaryTreeNode<>(element);
    }
    
     @Override
    public T getRoot() throws EmptyCollectionException {
        if (this.count == 0) {
            throw new EmptyCollectionException("The tree is empty");
        }

        return this.root.element;
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
        return findAgain(targetElement, this.root) != null;
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, this.root);

        if (current == null) {
            throw new ElementNotFoundException("binary tree");
        }

        return (current.element);
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>(this.count);
        inorder(root, tempList);

        return tempList.iterator();

    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>(this.count);
        preorder(root, tempList);

        return tempList.iterator();
    }

    protected void preorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.element);
            preorder(node.left, tempList);
            preorder(node.right, tempList);
        }

    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>(this.count);
        postorder(root, tempList);

        return tempList.iterator();
    }

    protected void postorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            postorder(node.left, tempList);
            postorder(node.right, tempList);
            tempList.addToRear(node.element);
        }

    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        QueueADT<BinaryTreeNode> nodes = new LinkedQueue<>();
        ArrayUnorderedList<T> results = new ArrayUnorderedList<>(this.count);
        BinaryTreeNode<T> node;

        nodes.enqueue(this.root);

        while (!(nodes.isEmpty())) {

            try {
                node = nodes.dequeue();

                if (node.element != null) {
                    results.addToRear((T) node.element);

                    if (node.left.element != null) {
                        nodes.enqueue(node.left);
                    }

                    if (node.right.element != null) {
                        nodes.enqueue(node.right);
                    }
                }
            } catch (EmptyCollectionException ex) {
                System.out.println("Empty");;
            }

        }
        return results.iterator();
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    private BinaryTreeNode<T> findAgain(T targetElement,
            BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);

        if (temp == null) {
            temp = findAgain(targetElement, next.right);
        }

        return temp;
    }

    @Override
    public String toString() {
        return "This is a Binary Linked Tree with " + this.count + " element(s)";
    }

   
}
