/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author fabio
 */
public class EmptyCollectionException extends Exception {

    /**
     * Creates a new instance of <code>RootVazioException</code> without detail
     * message.
     */
    public EmptyCollectionException() {
    }

    /**
     * Constructs an instance of <code>RootVazioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyCollectionException(String msg) {
        super(msg);
    }
}
