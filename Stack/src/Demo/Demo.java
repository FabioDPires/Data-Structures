/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import Exceptions.EmptyCollectionException;
import Stack.ArrayStack;
import Stack.LinkedStack;
import Stack.StackADT;

/**
 *
 * @author fabio
 */
public class Demo {

    /**
     * @param args the command line arguments
     * @throws Exceptions.EmptyCollectionException
     */
    public static void main(String[] args) throws EmptyCollectionException {
        StackADT<Integer> linkedStack = new ArrayStack<>();
        linkedStack.push(12);
        linkedStack.push(16);
        linkedStack.pop();
        System.out.println(linkedStack.toString());

    }

}
