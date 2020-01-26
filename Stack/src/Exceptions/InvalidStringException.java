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
public class InvalidStringException extends Exception {

    /**
     * Creates a new instance of <code>InvalidStringException</code> without
     * detail message.
     */
    public InvalidStringException() {
    }

    /**
     * Constructs an instance of <code>InvalidStringException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidStringException(String msg) {
        super(msg);
    }
}
