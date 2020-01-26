/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import Exceptions.EmptyCollectionException;
import Exceptions.InvalidStringException;

/**
 *
 * @author fabio
 */
public class CalculadoraArrayStack {

    private ArrayStack calculadora = new ArrayStack(5);

    public CalculadoraArrayStack() {
    }
 
   
  
    
    public void Calcular(String operacao) throws InvalidStringException, EmptyCollectionException{
        isValid(operacao);
        int n1,n2;
        for(int i=0;i<operacao.length();i++){
            char c=operacao.charAt(i);
            if (Character.isDigit(c)){
                n1=Character.getNumericValue(c);
                calculadora.push(n1);
            }
            else{
               n1=(int) calculadora.pop();
               n2=(int) calculadora.pop();
                switch(c){
                    case '+':
                        calculadora.push(n1+n2);
                        break;
                    case '-':
                        calculadora.push(n1*n2);
                        break;
                    case '*':
                        calculadora.push(n1*n2);
                        break;
                    case '/':
                        calculadora.push(n1/n2);
                        break;
                            
                }
                
                
                
            }
        }
        System.out.println("Resultado:"+calculadora.peek());
    }
    
    public static void isValid(String operacao) throws InvalidStringException{
       
        char c1=operacao.charAt(0);
        char c2=operacao.charAt(1);
        
            
        if(Character.isDigit(c1)==false || Character.isDigit(c2)==false){
            throw new InvalidStringException("O PRIMEIRO E O SEGUNDO CARACTER TEM DE SER NUMEROS!!");
        }
        int i = 0;
        boolean c = true;
        while (i < operacao.length() && c == true) {
            char caracter = operacao.charAt(i);
            if (Character.isDigit(caracter) == false && isOperator(caracter) ==false) {
                
                c=false;
            }
            
            i++;

        }
        if (c == false) {
            throw new InvalidStringException("ADICIONE SO NUMEROS E OPERADORES!!!");
        }
        
    }
public static boolean isOperator(char caracter){
    boolean c=false;
    if(caracter=='+'||caracter=='-'|| caracter=='/' ||caracter=='*'){
        c=true;
    }
    return c;
}
}
