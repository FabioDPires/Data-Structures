/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import Exceptions.EmptyCollectionException;
import Exceptions.InvalidStringException;
import Stack.CalculadoraArrayStack;
import Stack.LinkedStack;

/**
 *
 * @author fabio
 */
public class CalculadoraLinkedStack {

    private LinkedStack calculadora = new LinkedStack();

    public CalculadoraLinkedStack() {
    }

    public void Calcular(String operacao) throws InvalidStringException, EmptyCollectionException {
        CalculadoraArrayStack.isValid(operacao);
        int n1, n2;
        for (int i = 0; i < operacao.length(); i++) {
            char c = operacao.charAt(i);
            if (Character.isDigit(c)) {
                n1 = Character.getNumericValue(c);
                calculadora.push(n1);
            } else {
                n1 = (int) calculadora.pop();
                n2 = (int) calculadora.pop();
                switch (c) {
                    case '+':
                        calculadora.push(n1 + n2);
                        break;
                    case '-':
                        calculadora.push(n1 * n2);
                        break;
                    case '*':
                        calculadora.push(n1 * n2);
                        break;
                    case '/':
                        calculadora.push(n1 / n2);
                        break;
                }

            }
        }
        System.out.println("Resultado:"+calculadora.peek().toString());
    }
    
}
