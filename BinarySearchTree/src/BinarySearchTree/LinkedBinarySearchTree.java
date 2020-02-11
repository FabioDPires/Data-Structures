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
 * @param <T>
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary search
     * tree
     */
    public LinkedBinarySearchTree(T element) {
        super(element);
    }

    @Override
    /**
     * Adds the specified object to the binary search tree in the appropriate
     * position according to its key value. Note that equal elements are added
     * to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            this.root = temp;
        } else {
            BinaryTreeNode<T> current = this.root;
            boolean added = false;
            while (!added) {
                if (comparableElement.compareTo(current.element) < 0) {
                    if (current.left == null) {
                        current.left = temp;
                        added = true;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = temp;
                        added = true;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
       T result = null;

      if (!isEmpty())

         if (((Comparable)targetElement).equals(root.element)) 
         {
            result =  this.root.element;
            this.root = replacement (this.root);
            this.count--;
         } //if
        else 
        {
            BinaryTreeNode<T> current, parent = this.root;
            boolean found = false;

            if (((Comparable)targetElement).compareTo(this.root.element) < 0)
               current = this.root.left;
            else
               current = this.root.right;

            while (current != null && !found) 
            {
               if (targetElement.equals(current.element)) 
               {
                  found = true;
                  this.count--;
                  result =  current.element;
          
                  if (current == parent.left)
                  {
                     parent.left = replacement (current);
                  }
                  else
                  {
                     parent.right = replacement (current);
                  }
               } //if
              else 
              {
                  parent = current;
         
                  if (((Comparable)targetElement).compareTo(current.element) < 0)
                     current = current.left;
                  else
                     current = current.right;
               } //else
            } //while
            if (!found)
               throw new ElementNotFoundException("binary tree");
         } //else

      return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
        removeElement(targetElement);

        try {
            while (true) {
                removeElement(targetElement);
            }
        } catch (ElementNotFoundException a) {

        }

    }

    @Override
    public T removeMin() {
        T result = null;

        //If root doesn´t have left child
        if (this.root.left == null) {
            result = this.root.element;
            this.root = replacement(this.root);
            this.count--;
        } //If root does have left child
        else {
            BinaryTreeNode<T> current = this.root;
            BinaryTreeNode<T> parent = this.root;

            while (current.left != null) {
                parent = current;
                current = current.left;
            }

            result = current.element;
            parent.left = replacement(current);
            this.count--;
        }

        return result;
    }

    @Override
    public T removeMax() {
        T result = null;

        //If root doesn´t have right child
        if (this.root.right == null) {
            result = this.root.element;
            this.root = replacement(this.root);
            this.count--;
        } //If root does have right child
        else {
            BinaryTreeNode<T> parent = this.root;
            BinaryTreeNode<T> current = this.root;

            while (current.right != null) {
                parent = current;
                current = parent.right;
            }

            result = current.element;
            parent.right = replacement(current);
            this.count--;
        }

        return result;

    }

    @Override
    public T findMin() {
        BinaryTreeNode<T> current = this.root;
        while (current.left != null) {
            current = current.left;
        }

        return current.element;
    }

    @Override
    public T findMax() {
        BinaryTreeNode<T> current = this.root;
        while (current.right != null) {
            current = current.right;
        }

        return current.element;
    }

    /**
     * Returns a reference to a node that will replace the one specified for
     * removal. In the case where the removed node has two children, the inorder
     * successor is used as its replacement.
     *
     * @param node the node to be removeed
     * @return a reference to the replacing node
     */
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;

      if ((node.left == null)&&(node.right==null))
            result = null;
      else if ((node.left != null)&&(node.right==null))
            result = node.left;
      else if ((node.left == null)&&(node.right != null))
            result = node.right;
      else
      {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;

            while (current.left != null) 
            {
               parent = current;
               current = current.left;
            }//while

            if (node.right == current)
               current.left = node.left;
            else
            {
               parent.left = current.right;
               current.right = node.right;
               current.left = node.left;
            }
            result = current;
      }//else
      return result;

    }
}
