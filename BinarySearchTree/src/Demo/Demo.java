/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import BinarySearchTree.ArrayBinarySearchTree;
import BinarySearchTree.BinarySearchTreeADT;
import BinarySearchTree.LinkedBinarySearchTree;
import Exceptions.ElementNotFoundException;
import java.util.Iterator;

/**
 *
 * @author Fabio
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ElementNotFoundException {
        BinarySearchTreeADT<Integer> procuraLista = new LinkedBinarySearchTree<>(15);
        procuraLista.addElement(10);
        
        procuraLista.addElement(12);
        procuraLista.addElement(7);
        procuraLista.addElement(8);
       procuraLista.removeElement(10);

       
        Iterator t = procuraLista.iteratorLevelOrder(); 

        while (t.hasNext()) {
            System.out.println(t.next());
        }

    }
    }
    

