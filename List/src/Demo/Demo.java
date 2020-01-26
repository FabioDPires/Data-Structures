/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import List.DoubleLinkedUnorderedList;
import List.UnorderedListADT;
import java.util.Iterator;

/**
 *
 * @author fabio
 */
public class Demo {

    /**
     * @param args the command line arguments
     * @throws Exceptions.EmptyCollectionException
     * @throws Exceptions.ElementNotFoundException
     */
    public static void main(String[] args) throws EmptyCollectionException, ElementNotFoundException {
        UnorderedListADT<Integer> ul=new DoubleLinkedUnorderedList<>();
        ul.addToFront(22);
        ul.addToFront(31);
        ul.addToRear(52);
        ul.addAfter(19, 22);
        ul.addAfter(15, 52);
        
        
        Iterator<Integer> t= ul.iterator();
        while(t.hasNext()){
            System.out.println(t.next());
        }
        
        
        
    }
    
}
