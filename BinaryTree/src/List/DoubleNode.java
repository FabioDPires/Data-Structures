/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author fabio
 */
public class DoubleNode<T> {
    private DoubleNode<T> next;
    private DoubleNode<T> previous;
    private T element;

    public DoubleNode() {
        this.next=null;
        this.previous=null;
        this.element=null;
    }

    public DoubleNode(T element) {
        this.element = element;
        this.next=null;
        this.previous=null;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return ""+element;
    }
    
    
    
   
   
}
