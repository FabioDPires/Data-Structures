/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import Exceptions.EmptyCollectionException;
import Queue.CircularArrayQueue;
import Queue.LinkedQueue;
import Queue.QueueADT;

/**
 *
 * @author fabio
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        QueueADT<Integer> arrayqueue=new CircularArrayQueue<>(1);
        arrayqueue.enqueue(22);
        arrayqueue.enqueue(19);
        arrayqueue.dequeue();
        System.out.println(arrayqueue.toString());
        
       
     
       
        
        
    }
    
}
